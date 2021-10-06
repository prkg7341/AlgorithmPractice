package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471 {

	static int min = 987654321;
	static int n;
	static int[] population;
	static ArrayList<ArrayList<Integer>> edges;
	static HashSet<Integer> team1 = new HashSet<>();
	static HashSet<Integer> team2 = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		population = new int[n];
		edges = new ArrayList<>(n);

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(stringTokenizer.nextToken());
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());

			stringTokenizer.nextToken();

			while (stringTokenizer.hasMoreTokens()) {
				int vertex = Integer.parseInt(stringTokenizer.nextToken()) - 1;
				if (vertex < 0)
					continue;
				edges.get(i).add(vertex);
			}
		}

		team1.add(0);
		rec(1);

		if (min == 987654321)
			min = -1;
		System.out.println(min);
	}

	private static void rec(int index) {
		if (index == n) {
//			System.out.println(team1.size()+"\t"+team2.size());
			if (team2.isEmpty())
				return;

			Queue<Integer> queue = new LinkedList<>();
			queue.add(0);

			int count = 0;
			boolean[] visit = new boolean[n];
			visit[0] = true;
			count++;

			int t1 = 0, t2 = 0;
			t1 += population[0];

			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int num : edges.get(now)) {
					if (!visit[num] && team1.contains(num)) {
						visit[num] = true;
						queue.add(num);
						count++;
						t1 += population[num];
					}
				}
			}

			if (count != team1.size())
				return;

			int start = 0;

			for (int i = 1; i < n; i++) {
				if (!visit[i]) {
					start = i;
					break;
				}
			}

			queue = new LinkedList<>();
			queue.add(start);

			count = 0;
			t2 += population[start];

			visit[start] = true;
			count++;

			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int num : edges.get(now)) {
					if (!visit[num] && team2.contains(num)) {
						visit[num] = true;
						queue.add(num);
						count++;
						t2 += population[num];
					}
				}
			}

			if (count == team2.size()) {
//				System.out.println(t1 + " " + t2);
				min = Math.min(min, Math.abs(t1 - t2));
			}

			return;
		}

		team1.add(index);
		rec(index + 1);

		team1.remove(index);
		team2.add(index);
		rec(index + 1);
		team2.remove(index);
	}
}
