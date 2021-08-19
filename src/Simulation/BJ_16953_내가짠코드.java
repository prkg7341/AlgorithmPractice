package Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16953_내가짠코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		Queue<Number> q = new LinkedList<>();

		q.add(new Number(from, 1));

		boolean[] visit = new boolean[to + 1];

		while (!q.isEmpty()) {
			Number now = q.poll();

			if (now.value == to) {
				System.out.println(now.count);
				return;
			}

			int newVal = 2 * now.value;
			if (newVal <= to && !visit[newVal]) {
				visit[newVal] = true;
				q.add(new Number(newVal, now.count + 1));
			}

			try {
				newVal = Integer.parseInt(Integer.toString(now.value) + 1);
				if (newVal <= to && !visit[newVal]) {
					visit[newVal] = true;
					q.add(new Number(newVal, now.count + 1));
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		System.out.println(-1);
	}

	static class Number {
		int value, count;

		public Number(int value, int count) {
			super();
			this.value = value;
			this.count = count;
		}
	}
}