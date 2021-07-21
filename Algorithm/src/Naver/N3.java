package Naver;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class N3 {

	public int[] solution(int[][] data) {

		int[] answer = new int[data.length];
		int index = 0;

		ArrayList<Paper> yet = new ArrayList<>();
		PriorityQueue<Paper> pq = new PriorityQueue<>();

		for(int i=0 ; i<data.length ; i++) {
			yet.add(new Paper(data[i][0], data[i][1], data[i][2]));
		}

		for(int time=0 ; !(yet.isEmpty() && pq.isEmpty()) ; time++) {
			while(!yet.isEmpty() && yet.get(0).time<=time) {
				pq.add(yet.remove(0));
			}
			if(!pq.isEmpty()) {
				Paper now = pq.poll();
				time += now.page-1;
				answer[index++] = now.id;
			}
			else {
				int tt = yet.get(0).time;
				time += tt-time-1;
			}
		}

		return answer;
	}
	static class Paper implements Comparable<Paper>{
		int id, time, page;
		Paper(int id, int time, int page){
			this.id = id;
			this.time = time;
			this.page = page;
		}
		@Override
		public int compareTo(Paper o) {
			int ret = 0;
			int result = Integer.compare(this.page, o.page);
			if(result==0) {
				ret = this.time > o.time? 1 : -1;
			}
			else {
				ret = result;
			}		
			return ret;
		}
	}
}
