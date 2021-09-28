package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124 {

	static int[] root;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(stringTokenizer.nextToken());
			int num = Integer.parseInt(stringTokenizer.nextToken());

			root = new int[n];

			Arrays.fill(root, -1);

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			for (int i = 0; i < num; i++) {
				stringTokenizer = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
				int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;
				int distance = Integer.parseInt(stringTokenizer.nextToken());

				pq.add(new Edge(a, b, distance));
			}

			int count = 1;
			long sum = 0;

			while (count < n) {
				Edge now = pq.poll();
				if (union(now.a, now.b)) {
					count++;
					sum = (long) (sum + (long) now.distance);
				}
			}

			System.out.printf("#%d %d\n", tt, sum);
		}
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		if (root[a] < root[b] || (root[a] == -1 && root[b] == -1)) {
			root[a] += root[b];
			root[b] = a;
		} else {
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
}
