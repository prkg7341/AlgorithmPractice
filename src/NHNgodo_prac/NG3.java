package NHNgodo_prac;

import java.util.LinkedList;
import java.util.Queue;

public class NG3 {
	public int solution(int[] goldValues){

		// ������ ���� ���� �� �ʱ�ȭ
		int ret = 0;

		// Ȧ�� ¦�� ���η� ���� ������ ���� ���Կ� ģ���� ������ ���� ���Ը� �Ǻ��ϱ� ���� ����
		int count = 0;

		// �ùķ��̼��� ���� ť ����
		Queue<Index> q = new LinkedList<>();

		// ť�� ��ü�迭�� �ε��� ����
		q.add(new Index(0, goldValues.length));

		// ��Ұ� �����ִ� ���� �ݺ�
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int k=0 ; k<size ; k++) {
				Index now = q.poll();
				
				while(now.end<now.start || now.start<0) {
					now.end += goldValues.length;
				}
				
				while(now.end-now.start>goldValues.length) {
					now.end -= goldValues.length;
				}

				int max = 0;
				int max_i = -1;

				// �� �κй迭���� �ִ밪�� �� �ε��� ã��
				for(int i=now.start ; i<now.end ; i++) {

					int temp_i = i%goldValues.length;

					if(goldValues[temp_i]>max) {
						max = goldValues[temp_i];
						max_i = temp_i;
					}
				}

				// ���ϰ� ����
				if(count%2==0) {
					ret += max;
				}

				// �κй迭 ����
				if((now.start+1)%goldValues.length == (now.end)%goldValues.length) {
					continue;
				}
				else if(count==0) {
					q.add(new Index(max_i+1, max_i+goldValues.length));
				}
				else {
					if(max_i!=now.start) q.add(new Index(now.start, max_i));
					if(max_i!=now.end-1) q.add(new Index(max_i+1, now.end));
				}
			}
			count++;
		}

		return ret;
	}

	// �κй迭�� �ε����� �����ϴ� Ŭ���� ����
	static class Index{
		int start, end;
		Index(int s, int e){
			start = s;
			end = e;
		}
	}
}
