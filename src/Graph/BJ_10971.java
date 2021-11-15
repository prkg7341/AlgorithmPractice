package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971 {

	static int min = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rec(ar, 0, 0, 1);

		System.out.println(min);
	}

	private static void rec(int[][] ar, int now, int sum, int visit) {
		if (visit == (1 << ar.length) - 1) {
			if (ar[now][0] != 0)
				min = Math.min(min, sum + ar[now][0]);
			return;
		}

		for (int i = 1; i < ar.length; i++) {
			if ((visit & (1 << i)) == 0) {
				if (ar[now][i] != 0)
					rec(ar, i, sum + ar[now][i], visit | 1 << i);
			}
		}
	}
}