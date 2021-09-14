package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4386 {

	static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		double[][] ar = new double[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar[i][0] = Double.parseDouble(st.nextToken());
			ar[i][1] = Double.parseDouble(st.nextToken());
		}

		PriorityQueue<Line> pq = new PriorityQueue<>();
		root = new int[n];

		Arrays.fill(root, -1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				pq.add(new Line(i, j, Math.sqrt(Math.pow(ar[i][0] - ar[j][0], 2) + Math.pow(ar[i][1] - ar[j][1], 2))));
			}
		}

		int count = 1;
		double sum = 0;
		while (count < n) {
			Line now = pq.poll();

			if (union(now.index1, now.index2)) {
				sum += now.distance;
				count++;
			}
		}

		System.out.println(String.format("%.2f", sum));
	}

	private static boolean union(int index1, int index2) {
		index1 = find(index1);
		index2 = find(index2);

		if (index1 == index2)
			return false;

		if (root[index1] < root[index2] || (root[index1] == -1 && root[index2] == -1)) {
			root[index1] += root[index2];
			root[index2] = index1;
		} else {
			root[index2] += root[index1];
			root[index1] = index2;
		}
		return true;
	}

	private static int find(int index) {
		if (root[index] < 0)
			return index;
		return index = find(root[index]);
	}

	static class Line implements Comparable<Line> {
		int index1, index2;
		double distance;

		public Line(int index1, int index2, double d) {
			this.index1 = index1;
			this.index2 = index2;
			this.distance = d;
		}

		@Override
		public int compareTo(Line o) {
			return (int) (this.distance - o.distance);
		}
	}
}