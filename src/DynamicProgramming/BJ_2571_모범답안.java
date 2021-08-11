package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2571_모범답안 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] ar = new int[101][101];

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 검은종이 붙이기
			fill(ar, r, c);
		}

		// 배열을 누적합배열로 만들기
		dp(ar);

		int max = 0;

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				int h = 123456789;
				for (int x = j; x <= 100; x++) {
					if (ar[i][x] == 0)
						break;
					h = Math.min(h, ar[i][x]);
					max = Math.max(max, h * (x - j + 1));
					// System.out.println(max);
				}
			}
		}

		System.out.println(max);
	}

	private static void dp(int[][] ar) {
		for (int i = 1; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				if (ar[j][i] > 0)
					ar[j][i] += ar[j - 1][i];
			}
		}
	}

	private static void fill(int[][] ar, int r, int c) {
		for (int i = r; i < r + 10; i++) {
			for (int j = c; j < c + 10; j++) {
				ar[i][j] = 1;
			}
		}
	}
}