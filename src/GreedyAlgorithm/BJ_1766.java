package GreedyAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1766 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> after = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			after.add(new ArrayList<>());
		int[] before = new int[n];

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			after.get(a).add(b);
			before[b]++;
		}

		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			if (before[i] == 0)
				pQueue.add(i);
		}

		StringBuilder sBuilder = new StringBuilder();

		while (!pQueue.isEmpty()) {
			int now = pQueue.poll();

			sBuilder.append(now+1).append(" ");

			for (int next : after.get(now)) {
				if (--before[next] == 0)
					pQueue.add(next);
			}
		}

		System.out.println(sBuilder);
	}
}