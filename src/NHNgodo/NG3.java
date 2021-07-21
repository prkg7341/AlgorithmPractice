package NHNgodo;

import java.util.HashMap;

public class NG3 {
	public int solution(String s, int n){

		// 알파벳 별 개수를 구해 저장할 해쉬맵 생성
		HashMap<Character, Integer> map = new HashMap<>();

		char[] char_ar = s.toCharArray();

		// 가장 많이 등장하는 글자의 개수
		int max = 0;

		// 해쉬맵 업데이트
		for(int i=0 ; i<char_ar.length ; i++) {
			char now = char_ar[i];
			if(map.containsKey(now)) {
				map.put(now, map.get(now)+1);
				max = Math.max(max, map.get(now));
			}
			else {
				map.put(now, 1);
				max = Math.max(max, 1);
			}
		}

		// 글자 별 개수가 등장하는 횟수를 저장하는 배열 
		int[] ar = new int[max+1];

		for(Character cha : map.keySet()) {
			ar[map.get(cha)]++;
		}

		// 가장 적게 등장하는 글자의 개수
		int min = 0;

		for(int i=0 ; i<ar.length ; i++) {
			if(ar[i]>0) {
				min = i;
				break;
			}
		}

		// 글자를 삭제하지 않았을때의 거친정도를 리턴값에 저장
		int ret = max-min;

		ret = rec(ar, ret, min, max, n);		

		// 삭제횟수가 n회를 넘어가면 거친정도를 1 증가시킴
		if(n<0) ret++;

		return ret;
	}

	private int rec(int[] ar, int ret, int min, int max, int n) {
		
		if(min==max) {
			return 0;
		}
		
		if(ar[min]==0) {
			return rec(ar, ret-1, min+1, max, n);
		}
		if(ar[max]==0) {
			ret--;
			max--;
			return rec(ar, ret-1, min, max-1, n);
		}
		
		int temp = ret;
		
		if(n>=ar[min]*min) {
			temp = Math.min(temp, rec(ar, ret-1, min+1, max, n-ar[min]*min));
		}
		if(n>=ar[max]) {
			int swap = ar[max-1];
			ar[max-1] += ar[max];
			temp = Math.min(temp, rec(ar, ret-1, min, max-1, n-ar[max]));
			ar[max-1] = swap;
		}
		
		return temp;
	}
}
