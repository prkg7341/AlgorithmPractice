package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17142 {

	static int l;
	static int num;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static int minT = 987654321;
	static int[][] map;
	static int blank = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());

		ArrayList<Position> list = new ArrayList<>();
		Position[] virus = new Position[num];

		map = new int[l][l];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < l; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1) {
					map[i][j] = 1;
				} else {
					if (now == 2) {
						list.add(new Position(i, j, 0));
						map[i][j] = 2;
					} else
						blank++;
				}
			}
		}

		c(list, virus, 0, 0);

		if (minT == 987654321)
			minT = -1;
		System.out.println(minT);
	}

	private static void c(ArrayList<Position> list, Position[] virus, int index, int depth) {
		if (depth == num) {
			int[][] map_ = new int[l][l];

			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					map_[i][j] = map[i][j];
				}
			}

			Queue<Position> queue = new LinkedList<>();

			for (Position p : virus) {
				map_[p.r][p.c] = -2;
				queue.add(p);
			}

			int time = 0;
			int temp_count = 0;

			while (!queue.isEmpty()) {
				Position now = queue.poll();
				if (!now.isVirus)
					time = Math.max(time, now.time);
				for (int i = 0; i < 4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];

					if (nr >= 0 && nr < l && nc >= 0 && nc < l) {
						if (map_[nr][nc] == 0) {
							temp_count++;
							map_[nr][nc] = -1;
							queue.add(new Position(nr, nc, now.time + 1));
						} else if (map_[nr][nc] == 2) {
							map_[nr][nc] = -2;
							queue.add(new Position(nr, nc, now.time + 1, true));
						}
					}
				}
			}
			if (temp_count == blank)
				minT = Math.min(minT, time);

			return;
		}

		if (index == list.size()) {
			return;
		}

		c(list, virus, index + 1, depth);
		virus[depth] = list.get(index);
		c(list, virus, index + 1, depth + 1);
	}

	static class Position {
		int r, c, time;
		boolean isVirus;

		public Position(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		public Position(int r, int c, int time, boolean isVirus) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.isVirus = isVirus;
		}
	}
}