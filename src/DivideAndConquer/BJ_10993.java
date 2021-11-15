package DivideAndConquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10993 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int r = 1;
		int c = 1;
		for (int i = 1; i < n; i++) {
			r = r * 2 + 1;
			c = c * 2 + 3;
		}

		boolean[][] ar = new boolean[r][c];

		rec(ar, n, 0, r - 1, 0, c - 1);

		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < (n % 2 == 0 ? c - i : c - r + i+1); j++) {
				boolean boo = ar[i][j];
				sBuilder.append(boo ? '*' : ' ');
			}
			sBuilder.append("\n");
		}

		System.out.print(sBuilder);
	}

	private static void rec(boolean[][] ar, int n, int r1, int r2, int c1, int c2) {
		if (n == 0)
			return;
		if (n % 2 == 0) {
			Arrays.fill(ar[r1], c1, c2 + 1, true);

			for (int i = r1 + 1; i <= r2; i++) {
				for (int j = c1 + 1; j < c2; j++) {
					if (i - r1 == j - c1 || i - r1 == (ar[0].length - j - 1) - c1) {
						ar[i][j] = true;
					}
				}
			}
			int midC = (c1 + c2) / 2;
			rec(ar, n - 1, r1 + 1, (r1 + r2) / 2, midC - (int) Math.pow(2, n - 1) + 2,
					midC + (int) Math.pow(2, n - 1) - 2);
		} else {
			for (int i = r1; i < r2; i++) {
				for (int j = c1 + 1; j < c2; j++) {
					if (i + j + 1 - r1 - c1 == r2 - r1 + 1 || j - i + r1 - c1 == (c2 - c1 + 1) / 2) {
						ar[i][j] = true;
					}
				}
			}

			Arrays.fill(ar[r2], c1, c2 + 1, true);
			int midC = (c1 + c2) / 2;
			rec(ar, n - 1, (r1 + r2) / 2, r2 - 1, midC - (int) Math.pow(2, n - 1) + 2,
					midC + (int) Math.pow(2, n - 1) - 2);
		}
	}
}