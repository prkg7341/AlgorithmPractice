package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17472 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[] root;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());

		int[][] map = new int[r][c];

		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		int id = -1;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 1) {
					Queue<Position> q = new LinkedList<>();
					q.add(new Position(i, j));
					map[i][j] = id;

					while (!q.isEmpty()) {
						Position now = q.poll();
						for (int k = 0; k < 4; k++) {
							int newR = now.r + dr[k];
							int newC = now.c + dc[k];

							if (newR >= 0 && newC >= 0 && newR < r && newC < c)
								if (map[newR][newC] == 1) {
									map[newR][newC] = id;
									q.add(new Position(newR, newC));
								}
						}
					}
					id--;
				}
			}
		}

		int num = -id;
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < r; i++) {
			int index = -1;
			int temp_id = 0;
			for (int j = 0; j < c; j++) {
				if (map[i][j] < 0) {
					if (index == -1) {
						index = j;
						temp_id = map[i][j];
					} else {
						if (temp_id != map[i][j]) {
							int distance = j - index - 1;
							if (distance >= 2)
								pq.add(new Edge(-temp_id, -map[i][j], distance));
						}
						index = j;
						temp_id = map[i][j];
					}
				}
			}
		}
		for (int j = 0; j < c; j++) {
			int index = -1;
			int temp_id = 0;
			for (int i = 0; i < r; i++) {
				if (map[i][j] < 0) {
					if (index == -1) {
						index = i;
						temp_id = map[i][j];
					} else {
						if (temp_id != map[i][j]) {
							int distance = i - index - 1;
							if (distance >= 2)
								pq.add(new Edge(-temp_id, -map[i][j], distance));
						}
						index = i;
						temp_id = map[i][j];
					}
				}
			}
		}

		int sum = 0;
		int count = 1;

		root = new int[num--];
		Arrays.fill(root, -1);

		while (!pq.isEmpty() && count < num) {
			Edge now = pq.poll();

			if (union(now.a, now.b)) {
				count++;
				sum += now.distance;
			}
		}

		if (count < num)
			System.out.println(-1);
		else
			System.out.println(sum);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		if (root[a] < root[b] || (root[a] == -1 && root[b] == -1)) {
			root[a] += root[b];
			root[b] = a;
		}

		else {
			root[b] += root[a];
			root[a] = b;
		}

		return true;
	}

	private static int find(int a) {
		if (root[a] < 0)
			return a;
		return root[a] = find(root[a]);
	}

	static class Edge implements Comparable<Edge> {
		int a, b, distance;

		public Edge(int a, int b, int distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}

	static class Position {
		int r, c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
