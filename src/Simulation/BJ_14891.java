package Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] ar = new int[4][8];
		int[] index = { 0, 0, 0, 0 };

		for (int i = 0; i < 4; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				ar[i][j] = (int) (temp[j]-'0');
			}
		}

		int turn = Integer.parseInt(br.readLine());

		int score = 0;

		for (int i = 0; i < turn; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
			int what = Integer.parseInt(stringTokenizer.nextToken()) - 1;
			int where = -Integer.parseInt(stringTokenizer.nextToken());

			left(ar, index, what, where);
			right(ar, index, what, where, true);
		}
		for (int i = 0; i < 4; i++) {
			if (ar[i][index[i]] == 1)
				score += 1 << i;
		}

		System.out.println(score);
	}

	private static void right(int[][] ar, int[] index, int what, int where, boolean done) {
		if (what < 3) {
			int index1 = index[what] + 2;
			if (done)
				index1 -= where;
			index1 %= 8;
			int index2 = index[what + 1] - 2;
			if (index2 < 0)
				index2 += 8;
			if (ar[what][index1] != ar[what + 1][index2]) {
				right(ar, index, what + 1, -where, false);
			}
		}
		if (!done) {
			index[what] += where;
			index[what] %= 8;
			if (index[what] < 0)
				index[what] += 8;
		}
	}

	private static void left(int[][] ar, int[] index, int what, int where) {
		if (what > 0) {
			int index1 = index[what] - 2;
			if (index1 < 0)
				index1 += 8;
			int index2 = index[what - 1] + 2;
			index2 %= 8;
			if (ar[what][index1] != ar[what - 1][index2])
				left(ar, index, what - 1, -where);
		}

		index[what] += where;
		index[what] %= 8;
		if (index[what] < 0)
			index[what] += 8;
	}
}
