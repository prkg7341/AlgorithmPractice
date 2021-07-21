package NHNgodo_prac;

import java.util.LinkedList;
import java.util.Queue;

public class NG3 {
	public int solution(int[] goldValues){

		// 리턴할 변수 선언 및 초기화
		int ret = 0;

		// 홀수 짝수 여부로 내가 가지는 금의 무게와 친구가 가지는 금의 무게를 판별하기 위한 변수
		int count = 0;

		// 시뮬레이션을 위한 큐 생성
		Queue<Index> q = new LinkedList<>();

		// 큐에 전체배열의 인덱스 저장
		q.add(new Index(0, goldValues.length));

		// 요소가 남아있는 동안 반복
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

				// 각 부분배열에서 최대값과 그 인덱스 찾기
				for(int i=now.start ; i<now.end ; i++) {

					int temp_i = i%goldValues.length;

					if(goldValues[temp_i]>max) {
						max = goldValues[temp_i];
						max_i = temp_i;
					}
				}

				// 리턴값 수정
				if(count%2==0) {
					ret += max;
				}

				// 부분배열 저장
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

	// 부분배열의 인덱스를 저장하는 클래스 생성
	static class Index{
		int start, end;
		Index(int s, int e){
			start = s;
			end = e;
		}
	}
}
