package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1754_good {

	final static int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer sTokenizer = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(sTokenizer.nextToken());
		int num = Integer.parseInt(sTokenizer.nextToken());

		int[] ar = new int[n];
		boolean[] visit = new boolean[n];

		Arrays.fill(ar, INF);

		int start = Integer.parseInt(br.readLine()) - 1;
		ar[start] = 0;

		ArrayList<ArrayList<Pair>> list = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < num; i++) {
			sTokenizer = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(sTokenizer.nextToken()) - 1;
			int to = Integer.parseInt(sTokenizer.nextToken()) - 1;
			int distance = Integer.parseInt(sTokenizer.nextToken());

			list.get(from).add(new Pair(to, distance));
		}

		PriorityQueue<Pair> pQueue = new PriorityQueue<>();
		pQueue.add(new Pair(start, 0));

		int count = 1;

		while (!pQueue.isEmpty()) {
			Pair now = pQueue.poll();

			if (visit[now.index])
				continue;
			visit[now.index] = true;

			if (ar[now.index] == INF)
				count++;
			ar[now.index] = Math.min(ar[now.index], now.distance);

			if (count == n)
				break;

			for (Pair pair : list.get(now.index)) {
				if (!visit[pair.index]) {
					pQueue.add(new Pair(pair.index, now.distance + pair.distance));
				}
			}
		}

		for (int i : ar) {
			if (i == INF)
				System.out.println("INF");
			else
				System.out.println(i);
		}
	}

	static class Pair implements Comparable<Pair> {
		int index, distance;

		public Pair(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Pair o) {
			return this.distance - o.distance;
		}
	}
}
