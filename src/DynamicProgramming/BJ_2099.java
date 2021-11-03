package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2099 {
	static boolean[][] ar_first;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		boolean[][] ar = new boolean[n][n];
		ar_first = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			ar[i][a] = true;
			ar[i][b] = true;
		}

		for (int i = 0; i < n; i++) {
			ar_first[i] = ar[i].clone();
		}

		ar = mul(k);

		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			if (ar[from][to])
				sBuilder.append("death").append("\n");
			else
				sBuilder.append("life").append("\n");
		}

		System.out.println(sBuilder.toString());
	}

	private static boolean[][] mul(int k) {
		if (k == 1) {
			return ar_first;
		}

		boolean[][] temp_ar = mul(k / 2);
		temp_ar = cal(temp_ar, temp_ar);

		if (k % 2 == 1) {
			temp_ar = cal(temp_ar, ar_first);
		}

		return temp_ar;
	}

	private static boolean[][] cal(boolean[][] ar1, boolean[][] ar2) {
		int l = ar1.length;

		boolean[][] ret = new boolean[l][l];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				for (int k = 0; k < l; k++) {
					ret[i][j] |= ar1[i][k] & ar2[k][j];
				}
			}
		}

		return ret;
	}
}