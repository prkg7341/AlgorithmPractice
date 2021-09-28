package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636 {

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int row;
	static int col;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		row = Integer.parseInt(stringTokenizer.nextToken());
		col = Integer.parseInt(stringTokenizer.nextToken());

		int[][] ar = new int[row][col];
		HashSet<Integer> cheeze = new HashSet<>();

		for (int i = 0; i < row; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());
				if (temp == 1) {
					cheeze.add(i * 100 + j);
					ar[i][j] = 1;
				}
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		ar[0][0] = -1;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < 4; i++) {
				int newR = now / 100 + dr[i];
				int newC = now % 100 + dc[i];

				if (newR >= 0 && newC >= 0 && newR < row && newC < col) {
					if (ar[newR][newC] == 0) {
						int newPosition = newR * 100 + newC;
						q.add(newPosition);
						ar[newR][newC] = -1;
					}
				}
			}
		}

		int num = cheeze.size();

		for (int time = 0; time < 100; time++) {
			if (cheeze.isEmpty()) {
				System.out.println(time);
				System.out.println(num);
				return;
			}

			num = cheeze.size();

			LinkedList<Integer> toMelt = new LinkedList<>();

			for (int position : cheeze) {
				for (int i = 0; i < 4; i++) {
					int newR = position / 100 + dr[i];
					int newC = position % 100 + dc[i];

					if (newR >= 0 && newC >= 0 && newR < row && newC < col) {
						if (ar[newR][newC] == -1) {
							toMelt.add(position);
							continue;
						}
					}
				}
			}
			for (int position : toMelt) {
				ar[position / 100][position % 100] = -1;
				cheeze.remove(position);
				for (int i = 0; i < 4; i++) {
					int newR = position / 100 + dr[i];
					int newC = position % 100 + dc[i];
					if (newR >= 0 && newC >= 0 && newR < row && newC < col) {
						if (ar[newR][newC] == 0) {
							q = new LinkedList<>();
							int newPosition = newR * 100 + newC;
							q.add(newPosition);
							ar[newR][newC] = -1;

							while (!q.isEmpty()) {
								int now = q.poll();
								for (int j = 0; j < 4; j++) {
									int tempR = now / 100 + dr[j];
									int tempC = now % 100 + dc[j];

									if (ar[tempR][tempC] == 0) {
										q.add(tempR * 100 + tempC);
										ar[tempR][tempC] = -1;
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
