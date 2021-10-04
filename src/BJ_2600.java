import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2600 {

	static int b1;
	static int b2;
	static int b3;
	static int[][] now_win;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		b1 = Integer.parseInt(st.nextToken());
		b2 = Integer.parseInt(st.nextToken());
		b3 = Integer.parseInt(st.nextToken());

		now_win = new int[501][501];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());

			int k1 = Integer.parseInt(st.nextToken());
			int k2 = Integer.parseInt(st.nextToken());

			if(now_win[k1][k2] == 0) {
				game(k1, k2);
			}
			
			if (now_win[k1][k2] > 0)
				System.out.println('A');
			else
				System.out.println('B');
		}
	}

	private static void game(int k1, int k2) {
		if (k1 >= b3) {
			if (now_win[k1 - b3][k2] == 0) {
				game(k1 - b3, k2);
			}
			if (now_win[k1 - b3][k2] < 0) {
				now_win[k1][k2] = 1;
				return;
			}
		}
		if (k1 >= b2) {
			if (now_win[k1 - b2][k2] == 0) {
				game(k1 - b2, k2);
			}
			if (now_win[k1 - b2][k2] < 0) {
				now_win[k1][k2] = 1;
				return;
			}
		}
		if (k1 >= b1) {
			if (now_win[k1 - b1][k2] == 0) {
				game(k1 - b1, k2);
			}
			if (now_win[k1 - b1][k2] < 0) {
				now_win[k1][k2] = 1;
				return;
			}
		}
		if (k2 >= b3) {
			if (now_win[k1][k2 - b3] == 0) {
				game(k1, k2 - b3);
			}
			if (now_win[k1][k2 - b3] < 0) {
				now_win[k1][k2] = 1;
				return;
			}
		}
		if (k2 >= b2) {
			if (now_win[k1][k2 - b2] == 0) {
				game(k1, k2 - b2);
			}
			if (now_win[k1][k2 - b2] < 0) {
				now_win[k1][k2] = 1;
				return;
			}
		}
		if (k2 >= b1) {
			if (now_win[k1][k2 - b1] == 0) {
				game(k1, k2 - b1);
			}
			if (now_win[k1][k2 - b1] < 0) {
				now_win[k1][k2] = 1;
				return;
			}
		}

		now_win[k1][k2] = -1;
	}
}