package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485{

	static int[][] ar;
	static boolean[][] visit;

	static int[] dr = {0,0,1,-1};
	static int[] dc = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int index = 0;

		loop: while(true) {
			index++;
			int n = Integer.parseInt(br.readLine());

			if(n==0) return;

			ar = new int[n][n];
			visit = new boolean[n][n];

			for(int i=0 ; i<n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<n ; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Position> pq = new PriorityQueue<>();

			pq.add(new Position(0,0,ar[0][0]));

			visit[0][0] = true;

			while(!pq.isEmpty()) {
				Position now = pq.poll();
				visit[now.r][now.c] = true;
				for(int i=0 ; i<4 ; i++) {
					int nr = now.r+dr[i];
					int nc = now.c+dc[i];

					if(nr>=0 && nc>=0 && nr<n && nc<n) {
						if(nr==n-1 && nc==n-1) {
							System.out.println("Problem "+index+": "+(ar[nr][nc]+now.d));
							continue loop;
						}
						if(!visit[nr][nc]) {
							pq.add(new Position(nr,nc,ar[nr][nc]+now.d));
						}
					}
				}
			}			
		}
	}

	static class Position implements Comparable<Position>{
		int r,c,d;

		public Position(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Position o) {
			return this.d - o.d;
		}
	}
}