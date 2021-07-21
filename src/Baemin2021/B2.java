package Baemin2021;

import java.util.PriorityQueue;

public class B2 {
	public int solution(int n, String[] customers) {			

		PriorityQueue<Kiosk> pq = new PriorityQueue<>(n);

		for(int i=0 ; i<n ; i++) {
			pq.add(new Kiosk(i));
		}

		for(int i=0 ; i<customers.length ; i++) {
			String[] sp = customers[i].split(" ");

			String[] temp1 = sp[0].split("/");
			String[] temp2 = sp[1].split(":");

			int month = Integer.parseInt(temp1[0]);
			int day = Integer.parseInt(temp1[1]);
			int hour = Integer.parseInt(temp2[0]);
			int min = Integer.parseInt(temp2[1]);
			int sec = Integer.parseInt(temp2[2]);
			int time = Integer.parseInt(sp[2])*60;

			switch(month) {
			case 1: day += 0;
			break;
			case 2: day += 31;
			break;
			case 3: day += 59;
			break;
			case 4: day += 90;
			break;
			case 5: day += 120;
			break;
			case 6: day += 151;
			break;
			case 7: day += 181;
			break;
			case 8: day += 212;
			break;
			case 9: day += 243;
			break;
			case 10: day += 273;
			break;
			case 11: day += 304;
			break;
			case 12: day += 334;
			break;
			}

			hour += (day-1)*24;
			min += hour*60;
			sec += min*60;
			
			int temp_t = sec;
			Kiosk touse = pq.poll();
			System.out.println(touse.id+" "+touse.count+" "+touse.last);
			touse.count++;
			touse.last = temp_t+time;
			
			pq.add(touse);
		}

		int max = 0;

		while(!pq.isEmpty()) {
			Kiosk now = pq.poll();
			max = Math.max(max, now.count);
		}

		return max;
	}

	static class Kiosk implements Comparable<Kiosk>{
		int id;
		int last = 0;
		int count = 0;
		Kiosk(int id){
			this.id = id;
		}
		@Override
		public int compareTo(Kiosk o) {
			if(this.last==o.last) {
				return this.id - o.id;
			}
			else {
				return this.last - o.last;
			}
		}
	}
}
