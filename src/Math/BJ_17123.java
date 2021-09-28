package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17123 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 0; tt < t; tt++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			int[] row_ar = new int[n];
			int[] col_ar = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int now = Integer.parseInt(st.nextToken());

					row_ar[i] += now;
					col_ar[j] += now;
				}
			}

			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken()) - 1;
				int c1 = Integer.parseInt(st.nextToken()) - 1;
				int r2 = Integer.parseInt(st.nextToken()) - 1;
				int c2 = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken());

				for (int k = r1; k <= r2; k++) {
					row_ar[k] += v * (c2 - c1 + 1);
				}
				for (int k = c1; k <= c2; k++) {
					col_ar[k] += v * (r2 - r1 + 1);
				}
			}

			for (int i : row_ar)
				System.out.print(i + " ");
			System.out.println();
			for (int i : col_ar)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}