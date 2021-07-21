package NHNgodo;

import java.util.HashMap;

public class NG3 {
	public int solution(String s, int n){

		// ���ĺ� �� ������ ���� ������ �ؽ��� ����
		HashMap<Character, Integer> map = new HashMap<>();

		char[] char_ar = s.toCharArray();

		// ���� ���� �����ϴ� ������ ����
		int max = 0;

		// �ؽ��� ������Ʈ
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

		// ���� �� ������ �����ϴ� Ƚ���� �����ϴ� �迭 
		int[] ar = new int[max+1];

		for(Character cha : map.keySet()) {
			ar[map.get(cha)]++;
		}

		// ���� ���� �����ϴ� ������ ����
		int min = 0;

		for(int i=0 ; i<ar.length ; i++) {
			if(ar[i]>0) {
				min = i;
				break;
			}
		}

		// ���ڸ� �������� �ʾ������� ��ģ������ ���ϰ��� ����
		int ret = max-min;

		ret = rec(ar, ret, min, max, n);		

		// ����Ƚ���� nȸ�� �Ѿ�� ��ģ������ 1 ������Ŵ
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
