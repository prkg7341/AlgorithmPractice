package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251 {

	static int[] ar;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine());

			ar = new int[n];
			Arrays.fill(ar, -1);

			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
			long[] row = new long[n];
			for (int i = 0; i < n; i++) {
				row[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			stringTokenizer = new StringTokenizer(br.readLine());
			long[] col = new long[n];
			for (int i = 0; i < n; i++) {
				col[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			// 간선 다 때려박기
			PriorityQueue<Load> pQueue = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					pQueue.add(new Load(i, j, Math.abs(row[i] - row[j]) * Math.abs(row[i] - row[j])
							+ Math.abs(col[i] - col[j]) * Math.abs(col[i] - col[j])));
				}
			}

			int count = n - 1;
			double sum = 0;

			while (count > 0) {
				Load now = pQueue.poll();

				if (union(now.a, now.b)) {
					count--;
					sum += now.distance;
				}
			}

			double tax = Double.parseDouble(br.readLine());
			double ret = sum * tax;
			System.out.printf("#%d %d\n", tt, Math.round(ret));
		}
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (ar[a] == ar[b] && a != b) {
			ar[a] += ar[b];
			ar[b] = a;
			return true;
		} else if (ar[a] < ar[b]) {
			ar[a] += ar[b];
			ar[b] = a;
			return true;
		} else if (ar[a] > ar[b]) {
			ar[b] += ar[a];
			ar[a] = b;
			return true;
		}

		return false;
	}

	private static int find(int a) {
		if (ar[a] < 0)
			return a;
		return ar[a] = find(ar[a]);
	}

	static class Load implements Comparable<Load> {
		int a, b;
		double distance;

		public Load(int a, int b, double distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Load o) {
			if (this.distance < o.distance)
				return -1;
			else
				return 1;
		}
	}
}
