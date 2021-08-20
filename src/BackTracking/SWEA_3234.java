package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine());
			int[] ar = new int[n];

			StringTokenizer sTokenizer = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(sTokenizer.nextToken());
			}

			System.out.printf("#%d %d\n", tt, btrk(ar, new boolean[n], 0, 0, 0));
		}
	}

	private static int btrk(int[] ar, boolean[] visit, int depth, int left, int right) {
		if (right > left)
			return 0;
		if (depth == ar.length)
			return 1;

		int ret = 0;

		for (int i = 0; i < ar.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				ret += btrk(ar, visit, depth + 1, left, right + ar[i]);
				ret += btrk(ar, visit, depth + 1, left + ar[i], right);
				visit[i] = false;
			}
		}

		return ret;
	}
}
