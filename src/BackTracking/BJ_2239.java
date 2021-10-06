package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2239 {

	static int[][] ar;
	static ArrayList<Integer> list;
	static boolean[][] row = new boolean[10][10];
	static boolean[][] col = new boolean[10][10];
	static boolean[][] sector = new boolean[10][10];
	static boolean fin = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ar = new int[10][10];
		list = new ArrayList<>();

		for (int i = 1; i <= 9; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= 9; j++) {
				int now = (int) (input[j - 1] - '0');
				ar[i][j] = now;
				row[i][now] = true;
				col[j][now] = true;
				if (i <= 3) {
					if (j <= 3)
						sector[1][now] = true;
					else if (j <= 6)
						sector[2][now] = true;
					else
						sector[3][now] = true;
				} else if (i <= 6) {
					if (j <= 3)
						sector[4][now] = true;
					else if (j <= 6)
						sector[5][now] = true;
					else
						sector[6][now] = true;
				} else {
					if (j <= 3)
						sector[7][now] = true;
					else if (j <= 6)
						sector[8][now] = true;
					else
						sector[9][now] = true;
				}
				if (now == 0) {
					list.add(i * 10 + j);
				}
			}
		}

		btrk(0);
	}

	private static void btrk(int index) {
		if (index == list.size()) {
			fin = true;
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(ar[i][j]);
				}
				System.out.println();
			}
			return;
		}

		if (fin)
			return;

		int position = list.get(index);

		int r = position / 10;
		int c = position % 10;

		int sect;

		if (r <= 3) {
			if (c <= 3)
				sect = 1;
			else if (c <= 6)
				sect = 2;
			else
				sect = 3;
		} else if (r <= 6) {
			if (c <= 3)
				sect = 4;
			else if (c <= 6)
				sect = 5;
			else
				sect = 6;
		} else {
			if (c <= 3)
				sect = 7;
			else if (c <= 6)
				sect = 8;
			else
				sect = 9;
		}

		for (int i = 1; i <= 9; i++) {
			if (!row[r][i] && !col[c][i] && !sector[sect][i]) {
				row[r][i] = true;
				col[c][i] = true;
				sector[sect][i] = true;
				ar[r][c] = i;
				btrk(index + 1);
				row[r][i] = false;
				col[c][i] = false;
				sector[sect][i] = false;
				ar[r][c] = 0;
			}
		}
	}
}
