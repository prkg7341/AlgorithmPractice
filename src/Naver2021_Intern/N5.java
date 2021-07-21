package Naver2021_Intern;

public class N5 {
	public int solution(int[] cards) {

		int answer = 0;
		int p1 = 0;
		int p2 = 0;
		int back = 0;
		int front = 0;
		int p_ace = 0;
		int d_ace = 0;

		try{for(int i=0 ; i<cards.length ; i++) {
			int now = Math.min(10, cards[i]);
			if(p1==0) {
				p1 = now;
				if(now == 1) p_ace+=10;
				continue;
			}
			else if(back==0) {
				back = now;
				if(now == 1) d_ace+=10;
				continue;
			}
			else if(p2==0) {
				p2 = now;
				if(now == 1) p_ace+=10;
				continue;
			}
			else if(front==0) {
				front = now;
				if(now == 1) d_ace = 10;
			}

			if(p1+p2==21 || p1+p2+p_ace==21) {
				if(back+front==21 || back+front+d_ace==21) {

				}
				else answer +=3;
			}
			else {
				if(front==1 || front>=7) {
					while(p1+p2<17 && p1+p2+p_ace<17) {
						p2 += Math.min(10, cards[++i]);
						if(now==1 && p_ace==0) {
							p_ace += 10;
						}
					}
					if(p1+p2>21) {
						answer -= 2;
						p1 = 0;
						p2 = 0;
						back = 0;
						front = 0;
						p_ace = 0;
						d_ace = 0;
						continue;
					}
				}
				else if(front>=4 && front<=6) {

				}
				else {
					while(p1+p2<12 && p1+p2+p_ace<12) {
						p2 += Math.min(10, cards[++i]);
						if(now==1 && p_ace==0) {
							p_ace += 10;
						}
					}
					if(p1+p2>21) {
						answer -= 2;
						p1 = 0;
						p2 = 0;
						back = 0;
						front = 0;
						p_ace = 0;
						d_ace = 0;
						continue;
					}
				}
				
				while(back+front<17 && back+front+d_ace<17) {
					front += Math.min(10, cards[++i]);
					if(now==1 && d_ace==0) {
						d_ace += 10;
					}
				}
				if(back+front>21) {
					answer += 2;
					p1 = 0;
					p2 = 0;
					back = 0;
					front = 0;
					p_ace = 0;
					d_ace = 0;
					continue;
				}
				if(back+front+d_ace>21) {
					if(p1+p2>back+front) {
						answer += 2;
					}
					else if(p1+p2<back+front) {
						answer -= 2;
					}
				}
				else {
					if(p1+p2>back+front+d_ace) {
						answer += 2;
					}
					else if(p1+p2<back+front+d_ace) {
						answer -= 2;
					}
				}
			}
			p1 = 0;
			p2 = 0;
			back = 0;
			front = 0;
			p_ace = 0;
			d_ace = 0;
		}}catch(Exception e) {
			
		}

		return answer;
	}
}
