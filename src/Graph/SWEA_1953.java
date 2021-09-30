package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dr = { {}, { 0, 1, -1, 0 }, { 1, -1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
		int[][] dc = { {}, { 1, 0, 0, -1 }, { 0, 0 }, { 1, -1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(stringTokenizer.nextToken());
			int c = Integer.parseInt(stringTokenizer.nextToken());
			int startR = Integer.parseInt(stringTokenizer.nextToken());
			int startC = Integer.parseInt(stringTokenizer.nextToken());
			int time = Integer.parseInt(stringTokenizer.nextToken());

			int[][] ar = new int[r][c];
			boolean[][] visit = new boolean[r][c];

			for (int i = 0; i < r; i++) {
				stringTokenizer = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					ar[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

			Queue<Position> q = new LinkedList<>();

			q.add(new Position(startR, startC, 1));
			visit[startR][startC] = true;

			int count = 0;

			while (!q.isEmpty()) {
				Position now = q.poll();
				count++;

				if (now.time == time)
					continue;

				int[] now_dr = dr[ar[now.r][now.c]];
				int[] now_dc = dc[ar[now.r][now.c]];

				for (int i = 0; i < now_dr.length; i++) {
					int newR = now.r + now_dr[i];
					int newC = now.c + now_dc[i];

					if (newR < 0 || newC < 0 || newR >= r || newC >= c || visit[newR][newC] || ar[newR][newC] == 0)
						continue;

					boolean connected = false;

					int[] next_dr = dr[ar[newR][newC]];
					int[] next_dc = dc[ar[newR][newC]];

					for (int k = 0; k < next_dr.length; k++) {
						if (newR + next_dr[k] == now.r && newC + next_dc[k] == now.c)
							connected = true;
					}

					if (connected) {
						visit[newR][newC] = true;
						q.add(new Position(newR, newC, now.time + 1));
					}
				}
			}
			System.out.printf("#%d %d\n", tt, count);
		}
	}

	static class Position {
		int r, c, time;

		public Position(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
