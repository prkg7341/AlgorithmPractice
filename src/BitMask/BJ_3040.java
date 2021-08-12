package BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3040 {

	static boolean fin = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ar = new int[9];

		for (int i = 0; i < 9; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}

		boolean[] visit = new boolean[9];

		c(ar, visit, 0, 0);
	}

	private static void c(int[] ar, boolean[] visit, int index, int depth) {

		if (fin || index == 9)
			return;

		if (depth == 2) {
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (!visit[i]) {
					sb.append(ar[i]).append("\n");
					sum += ar[i];
				}
			}
			if (sum == 100) {
				System.out.print(sb);
				fin = true;
			}
			return;
		}

		for (int i = index; i < 9; i++) {
			visit[i] = true;
			c(ar, visit, index + 1, depth + 1);
			visit[i] = false;
			c(ar, visit, index + 1, depth);
		}
	}
}
