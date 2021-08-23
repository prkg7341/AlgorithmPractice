package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList<Integer>> list = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list.get(from).add(to);
			}

			Queue<Pair> q = new LinkedList<>();
			boolean[] visit = new boolean[n + 1];
			q.add(new Pair(start, 0));
			visit[start] = true;

			int maxCount = 0;
			int maxIndex = -1;

			while (!q.isEmpty()) {
				Pair now = q.poll();

				if (now.count > maxCount) {
					maxCount = now.count;
					maxIndex = now.index;
				} else if (now.index > maxIndex) {
					maxIndex = now.index;
				}

				ArrayList<Integer> temp = list.get(now.index);
				for (int i = 0; i < temp.size(); i++) {
					int next = temp.get(i);
					if (!visit[next]) {
						visit[next] = true;
						q.add(new Pair(next, now.count + 1));
					}
				}
			}

			System.out.printf("#%d %d\n", t, maxIndex);
		}
	}

	static class Pair {
		int index, count;

		public Pair(int val, int count) {
			this.index = val;
			this.count = count;
		}
	}
}
