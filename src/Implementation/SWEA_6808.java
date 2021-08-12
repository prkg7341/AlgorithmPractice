package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int win;
	static int lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			win = 0;
			lose = 0;

			int[] cards1 = new int[9];
			int[] cards2 = new int[9];

			boolean[] check = new boolean[19];

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 입력을 받아 card1 update
			for (int i = 0; i < 9; i++) {
				int card = Integer.parseInt(st.nextToken());
				cards1[i] = card;
				check[card] = true;
			}

			// cards2 update
			int index = 0;

			for (int i = 1; i <= 18; i++) {
				if (!check[i])
					cards2[index++] = i;
			}

			// 로직
			boolean[] visit = new boolean[9];
			int[] order = new int[9];

			p(cards1, cards2, order, visit, 0);

			System.out.printf("#%d %d %d\n", tt, win, lose);
		}
	}

	private static void p(int[] cards1, int[] cards2, int[] order, boolean[] visit, int depth) {
		if (depth == 9) {
			int temp_win = 0;
			int temp_lose = 0;
			for (int i = 0; i < 9; i++) {
				if (cards1[i] > order[i]) {
					temp_win += cards1[i] + order[i];
				} else {
					temp_lose += cards1[i] + order[i];
				}
			}
			if (temp_win > temp_lose)
				win++;
			else if (temp_win < temp_lose)
				lose++;
		}

		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				order[depth] = cards2[i];
				p(cards1, cards2, order, visit, depth + 1);
				visit[i] = false;
			}
		}
	}
}
