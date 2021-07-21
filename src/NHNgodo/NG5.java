package NHNgodo;

import java.util.Arrays;
import java.util.HashMap;

public class NG5 {
	public int solution(int[] votes){

		// ��ǥ�� ���̿� �� ��ǥ���� �ο��� ������ �ؽ��� ����
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// ���� ���� ��ǥ�� ����
		int max = 0;

		// �ؽ��ʰ� max ������Ʈ
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
		
		// �̹� ���� ���� ��ǥ���� ������ ������ 0 ����
		if(map.size()==0) return 0;

		// ��ǥ�� ���̿� �� �ο��� ������ �迭 ���� �� �ʱ�ȭ
		int[] ar = new int[max+1];

		for(int i : map.keySet()) {
			ar[i] = map.get(i);
		}
		
		System.out.println(Arrays.toString(ar));
		
		// ���ϰ� ���� �� 0���� �ʱ�ȭ
		int ret = 0;
		// �ݺ������� ����� ���� ���� ��ǥ��
		int max_i = max;
		
		while(ret<=max_i){
			// ��ǥ�� �� �־ �ȴٸ� 1�� ���ϰ� ����
			if(ret==max_i) {
				return ret+1;
			}
			ret += ar[max_i];
			ar[max_i-1] += ar[max_i--];
			
			System.out.println(Arrays.toString(ar));
		}
		
		// �ʰ��Ͽ� �ٲ� Ƚ���� �ٽ� ����
		while(ret>max_i+2) ret--;

		return ret;
	}
}
