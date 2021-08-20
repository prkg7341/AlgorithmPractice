package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_개선후 {

	static int row, col;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer sTokenizer = new StringTokenizer(br.readLine());

		row = Integer.parseInt(sTokenizer.nextToken());
		col = Integer.parseInt(sTokenizer.nextToken());

		boolean[][] ar = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if (input[j] == '.')
					ar[i][j] = true;
			}
		}

		int count = 0;

		for (int i = 0; i < row; i++) {
			if (reach(ar, i, 0))
				count++;
		}
		System.out.println(count);
	}

	private static boolean reach(boolean[][] ar, int r, int c) {
		if (r < 0 || r >= row)
			return false;
		if (c == col - 1) {
			boolean ret = ar[r][c];
			ar[r][c] = false;
			return ret;
		}
		if (ar[r][c]) {
			ar[r][c] = false;
			return reach(ar, r - 1, c + 1) || reach(ar, r, c + 1) || reach(ar, r + 1, c + 1);
		} else {
			return ar[r][c];
		}
	}
}
