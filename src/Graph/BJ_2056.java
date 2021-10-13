package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2056 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] before = new int[n];
		int[][] times = new int[n][2];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			times[i][0] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++) {
				int next = Integer.parseInt(st.nextToken()) - 1;
				list.get(i).add(next);
				before[next]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if (before[i] == 0) {
				q.add(i);
				times[i][1] = times[i][0];
			}
		}

		int max = times[0][1];

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				times[next][1] = Math.max(times[next][1], times[next][0] + times[now][1]);
				max = Math.max(max, times[next][1]);
				if (--before[next] == 0) {
					q.add(next);
				}
			}
		}
		System.out.println(max);
	}
}