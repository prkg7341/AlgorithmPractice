package BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1681 {

	static int min = 987654321;
	static int[][] visit = new int[12][1 << 12];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		int[][] ar = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer sTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ar[i][j] = Integer.parseInt(sTokenizer.nextToken());
			}
		}

		btrk(ar, 0, 1 << 0, 0, 1);

		System.out.println(min);
	}

	private static void btrk(int[][] ar, int now_index, int bit, int distance, int depth) {
		if (depth == ar.length) {
			if (ar[now_index][0] > 0)
				min = Math.min(min, distance + ar[now_index][0]);
			return;
		}
		if (visit[now_index][bit] > distance || visit[now_index][bit] == 0) {
			visit[now_index][bit] = distance;
		} else if (visit[now_index][bit] > 0 && visit[now_index][bit] <= distance)
			return;
		for (int i = 1; i < ar.length; i++) {
			if ((bit & 1 << i) == 0 && ar[now_index][i] > 0)
				btrk(ar, i, bit + (1 << i), distance + ar[now_index][i], depth + 1);
		}
	}
}
