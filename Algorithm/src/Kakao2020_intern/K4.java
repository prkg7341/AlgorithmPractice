package Kakao2020_intern;

import java.util.LinkedList;
import java.util.Queue;

public class K4 {
	public int solution(int[][] board) {

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		int[][][] min_cost = new int[board.length][board[0].length][4];

		Queue<Position> q = new LinkedList<>();

		q.add(new Position(0,0,0,0));
		q.add(new Position(0,0,1,0));

		int answer = Integer.MAX_VALUE;

		while(!q.isEmpty()) {
			Position now = q.poll();

			for(int i=0 ; i<4 ; i++) {
				if(Math.abs(i-now.direction)!=2) {
					int newX = now.x+dx[i];
					int newY = now.y+dy[i];

					if(newX<0 || newX==board.length || newY<0 || newY==board[0].length) continue;
					if(board[newX][newY]==1) continue;

					int newC = now.cost+100;
					if(i!=now.direction) newC+=500;

					if(newX==board.length-1 && newY==board[0].length-1) {
						answer = Math.min(answer, newC);
					}

					if(min_cost[now.x][now.y][i]==0 || newC<min_cost[now.x][now.y][i]) {
						min_cost[now.x][now.y][i] = newC;
						q.add(new Position(newX, newY, i, newC));
					}
				}
			}
		}

		return answer;
	}

	static class Position{
		int x;
		int y;
		int direction;
		int cost;
		Position(int x, int y, int direction, int cost){
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.cost = cost;
		}
	}
}
