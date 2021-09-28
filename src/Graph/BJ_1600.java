package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[] dr2 = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dc2 = { 1, -1, 2, -2, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(stringTokenizer.nextToken());
		int r = Integer.parseInt(stringTokenizer.nextToken());

		int[][] ar = new int[r][c];
		boolean[][][] visit = new boolean[r][c][31];

		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				ar[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		
		if(r==1 && c==1) {
			System.out.println(0);
			return;
		}

		int nowR = 0;
		int nowC = 0;

		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(nowR, nowC, num, 0));
		visit[nowR][nowC][num] = true;

		while (!queue.isEmpty()) {
			Position now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newR = now.r + dr[i];
				int newC = now.c + dc[i];

				if (newR == r - 1 && newC == c - 1) {
					System.out.println(now.count + 1);
					return;
				}

				if (newR >= 0 && newC >= 0 && newR < r && newC < c) {
					if (ar[newR][newC] == 1)
						continue;
					if (!visit[newR][newC][now.num]) {
						visit[newR][newC][now.num] = true;
						queue.add(new Position(newR, newC, now.num, now.count + 1));
					}
				}
			}

			if (now.num > 0)
				for (int i = 0; i < 8; i++) {
					int newR = now.r + dr2[i];
					int newC = now.c + dc2[i];

					if (newR == r - 1 && newC == c - 1) {
						System.out.println(now.count + 1);
						return;
					}

					if (newR >= 0 && newC >= 0 && newR < r && newC < c) {
						if (ar[newR][newC] == 1)
							continue;
						if (!visit[newR][newC][now.num - 1]) {
							visit[newR][newC][now.num - 1] = true;
							queue.add(new Position(newR, newC, now.num - 1, now.count + 1));
						}
					}
				}
		}
		System.out.println(-1);
	}

	static class Position {
		int r, c, num, count;

		public Position(int r, int c, int num, int count) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.count = count;
		}
	}
}
