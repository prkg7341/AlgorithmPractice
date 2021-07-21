package Kakao_SummerInternship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KSI2 {

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public int[] solution(String[][] places) {
		int[] answer = new int[5];

		Arrays.fill(answer, 1);

		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				for(int a=0 ; a<5 ; a++) {
					if(places[i][j].charAt(a)=='P') {
						if(!check(places, i, j, a)) answer[i] = 0;
					}
				}
			}
		}

		return answer;
	}

	private boolean check(String[][] places, int i, int j, int a) {

		Queue<Position> q = new LinkedList<>();

		q.add(new Position(j, a));

		Position now = q.poll();
		for(int k=0 ; k<4 ; k++) {
			int newX = now.x+dx[k];
			int newY = now.y+dy[k];
			if(newX>=0 && newX<5 && newY>=0 && newY<5) {
				if(places[i][newX].charAt(newY)=='P') {
					return false;
				}
				else if(places[i][newX].charAt(newY)=='O') {
					q.add(new Position(newX, newY));
				}
			}
		}

		int index = q.size();
		for(int z=0 ; z<index ; z++) {
			now = q.poll();
			for(int k=0 ; k<4 ; k++) {
				int newX = now.x+dx[k];
				int newY = now.y+dy[k];
				if(newX==j && newY==a) continue;
				if(newX>=0 && newX<5 && newY>=0 && newY<5) {
					if(places[i][newX].charAt(newY)=='P') {
						return false;
					}
				}
			}
		}

		return true;
	}

	static class Position{
		int x,y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
