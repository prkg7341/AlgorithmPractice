package NHNgodo;

import java.util.Arrays;
import java.util.HashMap;

public class NG5 {
	public int solution(int[] votes){

		// 투표수 차이와 각 투표수별 인원을 저장할 해쉬맵 선언
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// 가장 많은 투표수 저장
		int max = 0;

		// 해쉬맵과 max 업데이트
		for(int i=1 ; i<votes.length ; i++) {
			int now = votes[i];
			if(now<votes[0]) continue;
			now -= votes[0];
			max = Math.max(max, now);
			if(map.containsKey(now)) {
				map.put(now, map.get(now)+1);
			}
			else {
				map.put(now, 1);
			}
		}
		
		// 이미 가장 많은 투표수를 가지고 있으면 0 리턴
		if(map.size()==0) return 0;

		// 투표수 차이와 그 인원을 저장할 배열 선언 및 초기화
		int[] ar = new int[max+1];

		for(int i : map.keySet()) {
			ar[i] = map.get(i);
		}
		
		System.out.println(Arrays.toString(ar));
		
		// 리턴값 선언 및 0으로 초기화
		int ret = 0;
		// 반복문에서 사용할 가장 많은 투표수
		int max_i = max;
		
		while(ret<=max_i){
			// 한표만 더 있어도 된다면 1을 더하고 리턴
			if(ret==max_i) {
				return ret+1;
			}
			ret += ar[max_i];
			ar[max_i-1] += ar[max_i--];
			
			System.out.println(Arrays.toString(ar));
		}
		
		// 초과하여 바꾼 횟수를 다시 빼줌
		while(ret>max_i+2) ret--;

		return ret;
	}
}
