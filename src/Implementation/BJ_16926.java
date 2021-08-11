package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());
		int n = Integer.parseInt(stringTokenizer.nextToken());

		int[][] ar = new int[r][c];

		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				ar[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		// rotate
		for (int i = 0; i < n; i++) {
			int mid = Math.min(ar.length, ar[0].length) / 2;

			for (int x = 0; x < mid; x++) {
				int maxR = ar.length - x;
				int maxC = ar[0].length - x;
				int minR = x;
				int minC = x;

				int temp = ar[maxR - 1][minC];

				for (int j = maxR - 2; j >= minR; j--) {
					down(ar, j, minC);
				}

				for (int j = minC + 1; j < maxC; j++) {
					left(ar, minR, j);
				}

				for (int j = minR + 1; j < maxR; j++) {
					up(ar, j, maxC - 1);
				}

				for (int j = maxC - 2; j >= minC + 1; j--) {
					right(ar, maxR - 1, j);
				}
				ar[maxR - 1][minC + 1] = temp;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int[] temp_ar : ar) {
			for (int i : temp_ar) {
				stringBuilder.append(i).append(" ");
			}
			stringBuilder.append("\n");
		}
		System.out.println(stringBuilder);
	}

	private static void up(int[][] ar, int i, int j) {
		ar[i - 1][j] = ar[i][j];
	}

	private static void left(int[][] ar, int i, int j) {
		ar[i][j - 1] = ar[i][j];
	}

	private static void right(int[][] ar, int i, int j) {
		ar[i][j + 1] = ar[i][j];
	}

	private static void down(int[][] ar, int i, int j) {
		ar[i + 1][j] = ar[i][j];
	}
}
