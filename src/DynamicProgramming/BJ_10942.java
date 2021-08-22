package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] isPalindrome = new boolean[n][n];

		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j)
					continue;
				if (i == j) {
					q.add(new Pair(i, j));
				} else if (Math.abs(i - j) == 1) {
					if (ar[i] == ar[j]) {
						q.add(new Pair(i, j));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Pair now = q.poll();
			isPalindrome[now.from][now.to] = true;

			if (now.from >= 1 && now.to < n - 1 && ar[now.from - 1] == ar[now.to + 1])
				q.add(new Pair(now.from - 1, now.to + 1));
		}

		int num = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			if (isPalindrome[from][to])
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Pair {
		int from, to;

		public Pair(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
}