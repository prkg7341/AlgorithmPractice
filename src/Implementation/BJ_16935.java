package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());
		int n = Integer.parseInt(stringTokenizer.nextToken());

		int[][] ar = new int[r][c];

		for (int i = 0; i < ar.length; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		stringTokenizer = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int command = Integer.parseInt(stringTokenizer.nextToken());

			switch (command) {
			case 1:
				row(ar);
				break;
			case 2:
				col(ar);
				break;
			case 3:
				ar = right(ar);
				break;
			case 4:
				ar = left(ar);
				break;
			case 5:
				ar = swap1(ar);
				break;
			case 6:
				ar = swap2(ar);
				break;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		for (int[] temp : ar) {
			for (int num : temp) {
				sBuilder.append(num).append(" ");
			}
			sBuilder.append("\n");
		}
		System.out.print(sBuilder);
	}

	private static int[][] swap2(int[][] ar) {
		int[][] temp = new int[ar.length][ar[0].length];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				int r = i;
				int c = j;
				if (r >= ar.length / 2) {
					if (c >= ar[0].length / 2) {
						c -= ar[0].length / 2;
					} else {
						r -= ar.length / 2;
					}
				} else {
					if (c >= ar[0].length / 2) {
						r += ar.length / 2;
					} else {
						c += ar[0].length / 2;
					}
				}
				temp[i][j] = ar[r][c];
			}
		}
		return temp;
	}

	private static int[][] swap1(int[][] ar) {
		int[][] temp = new int[ar.length][ar[0].length];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				int r = i;
				int c = j;
				if (r >= ar.length / 2) {
					if (c >= ar[0].length / 2) {
						r -= ar.length / 2;
					} else {
						c += ar[0].length / 2;
					}
				} else {
					if (c >= ar[0].length / 2) {
						c -= ar[0].length / 2;
					} else {
						r += ar.length / 2;
					}
				}
				temp[i][j] = ar[r][c];
			}
		}
		return temp;
	}

	private static int[][] left(int[][] ar) {
		int[][] temp = new int[ar[0].length][ar.length];
		for (int i = ar[0].length - 1; i >= 0; i--) {
			for (int j = 0; j < ar.length; j++) {
				temp[i][j] = ar[j][ar[0].length - i - 1];
			}
		}
		return temp;
	}

	private static int[][] right(int[][] ar) {
		int[][] temp = new int[ar[0].length][ar.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = ar[ar.length - j - 1][i];
			}
		}
		return temp;
	}

	private static void col(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length / 2; j++) {
				int temp = ar[i][j];
				ar[i][j] = ar[i][ar[0].length - j - 1];
				ar[i][ar[0].length - j - 1] = temp;
			}
		}
	}

	private static void row(int[][] ar) {
		for (int i = 0; i < ar.length / 2; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				int temp = ar[i][j];
				ar[i][j] = ar[ar.length - i - 1][j];
				ar[ar.length - i - 1][j] = temp;
			}
		}
	}
}
