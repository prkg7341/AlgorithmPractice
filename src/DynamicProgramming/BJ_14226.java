package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14226 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int goal = Integer.parseInt(st.nextToken());

		boolean[][] visit = new boolean[goal * 2 + 1][goal * 2 + 1];
		visit[1][0] = true;
		PriorityQueue<Number> pQueue = new PriorityQueue<>();
		pQueue.add(new Number(1, 0, 0));
		while (!pQueue.isEmpty()) {
			Number now = pQueue.poll();

			if (now.value != now.cb && !visit[now.value][now.value]) {
				visit[now.value][now.value] = true;
				pQueue.add(new Number(now.value, now.count + 1, now.value));
			}
			if (now.cb > 0 && now.value + now.cb < visit.length && !visit[now.value + now.cb][now.cb]) {
				if (now.value + now.cb == goal) {
					System.out.println(now.count + 1);
					return;
				}
				visit[now.value + now.cb][now.cb] = true;
				pQueue.add(new Number(now.value + now.cb, now.count + 1, now.cb));
			}
			if (now.value > 1 && !visit[now.value - 1][now.cb]) {
				if (now.value - 1 == goal) {
					System.out.println(now.count + 1);
					return;
				}
				visit[now.value - 1][now.cb] = true;
				pQueue.add(new Number(now.value - 1, now.count + 1, now.cb));
			}
		}
	}

	static class Number implements Comparable<Number> {
		int value, count, cb;

		public Number(int value, int count, int cb) {
			this.value = value;
			this.count = count;
			this.cb = cb;
		}

		@Override
		public int compareTo(Number o) {
			return this.count - o.count;
		}
	}
}