package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_1249 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		testcase: for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine());

			int[][] ar = new int[n][n];
			int[][] visit = new int[n][n];

			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], 987654321);
			}

			for (int i = 0; i < n; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					ar[i][j] = (int) (temp[j] - '0');
				}
			}

			PriorityQueue<Position> q = new PriorityQueue<>();
			q.add(new Position(0, 0, 0));
			visit[0][0] = 0;

			while (!q.isEmpty()) {
				Position now = q.poll();

				for (int i = 0; i < 4; i++) {
					int newR = now.r + dr[i];
					int newC = now.c + dc[i];

					if (newR >= 0 && newC >= 0 && newR < n && newC < n) {
						if (newR == n - 1 && newC == n - 1) {
							System.out.printf("#%d %d\n", tt, now.distance);
							continue testcase;
						}
						if (visit[newR][newC] > now.distance + ar[newR][newC]) {
							visit[newR][newC] = now.distance + ar[newR][newC];
							q.add(new Position(newR, newC, now.distance + ar[newR][newC]));
						}
					}
				}
			}
		}
	}

	static class Position implements Comparable<Position> {
		int r, c, distance;

		public Position(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public int compareTo(Position o) {
			return this.distance - o.distance;
		}
	}
}
