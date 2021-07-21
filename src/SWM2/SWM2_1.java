package SWM2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWM2_1 {

	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,1,-1,0};

	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		test: for(int i=0 ; i<t ; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();

			int startr=-1, startc=-1;

			int[][] ar = new int[row][col];
			boolean[][] visit = new boolean[row][col];

			for(int r=0 ; r<row ; r++) {
				for(int c=0 ; c<col ; c++) {
					int now = sc.nextInt();

					if(now==3) {
						startr = r;
						startc = c;
					}

					ar[r][c] = now;
				}
			}

			int count = 0;

			Queue<Position> q = new LinkedList<>();

			q.add(new Position(startr, startc));
			visit[startr][startc] = true;

			while(!q.isEmpty()) {
				Position now = q.poll();

				for(int ii=0 ; ii<4 ; ii++) {
					int newR = now.r+dr[ii];
					int newC = now.c+dc[ii];

					if(newR>=row || newR<0 || newC>=col || newC<0) {
						continue;
					}

					if(ar[newR][newC]==1 || visit[newR][newC]) {
						continue;
					}

					if(ar[newR][newC]==2 || ar[newR][newC]==4) {
						count++;
						if(count==2) {
							System.out.println(1);
							continue test;
						}
					}

					visit[newR][newC] = true;
					q.add(new Position(newR, newC));
				}
			}
			System.out.println(0);
		}
	}

	static class Position{
		int c;
		int r;
		Position(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
