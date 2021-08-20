package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 0; tt < t; tt++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int rule = Integer.parseInt(st.nextToken());

			int[][] time = new int[n][2];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				time[i][0] = Integer.parseInt(st.nextToken());
			}

			int[] count = new int[n];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < rule; i++) {
				st = new StringTokenizer(br.readLine());

				int before = Integer.parseInt(st.nextToken()) - 1;
				int after = Integer.parseInt(st.nextToken()) - 1;

				list.get(before).add(after);
				count[after]++;
			}

			int goal = Integer.parseInt(br.readLine()) - 1;

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				if (count[i] == 0)
					q.add(i);
			}

			int max = 0;

			while (!q.isEmpty()) {
				int now = q.poll();
				int now_time = time[now][0] + time[now][1];
				max = Math.max(max, now_time);

				if (now == goal) {
					max = now_time;
					break;
				}

				for (int i : list.get(now)) {
					count[i]--;
					time[i][1] = Math.max(time[i][1], now_time);
					if (count[i] == 0)
						q.add(i);
				}
			}
			System.out.println(max);
		}
	}
}