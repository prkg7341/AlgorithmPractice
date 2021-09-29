package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1194 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());

		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		boolean[][][] visit = new boolean[r][c][2 << 7];

		char[][] map = new char[r][c];

		int startR = 0, startC = 0;

		for (int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				char now = temp[j];
				map[i][j] = now;
				if (now == '0') {
					startR = i;
					startC = j;
				}
			}
		}

		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(startR, startC, 0, 0));
		visit[startR][startC][0] = true;

		while (!queue.isEmpty()) {
			Position now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newR = now.r + dr[i];
				int newC = now.c + dc[i];

				if (newR >= 0 && newC >= 0 && newR < r && newC < c) {
					if (!visit[newR][newC][now.key]) {
						visit[newR][newC][now.key] = true;

						if (map[newR][newC] == '1') {
							System.out.println(now.count + 1);
							return;
						} else if (map[newR][newC] == '0' || map[newR][newC] == '.') {
							queue.add(new Position(newR, newC, now.count + 1, now.key));
						} else if (map[newR][newC] == '#') {
							continue;
						} else if (map[newR][newC] >= 'a' && map[newR][newC] <= 'f') {
							queue.add(new Position(newR, newC, now.count + 1, now.key | 2 << (map[newR][newC] - 'a')));
						} else {
							if ((now.key & (2 << (map[newR][newC] - 'a'))) > 0) {
								queue.add(new Position(newR, newC, now.count + 1, now.key));
							}
						}
					}
				}
			}
		}

		System.out.println(-1);
	}

	static class Position {
		int r, c, count, key;

		public Position(int r, int c, int count, int key) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.key = key;
		}
	}
}
