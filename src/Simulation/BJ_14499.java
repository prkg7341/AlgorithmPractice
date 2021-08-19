package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int commands = Integer.parseInt(st.nextToken());

		int[][] map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Dice dice = new Dice();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < commands; i++) {
			int com = Integer.parseInt(st.nextToken());
			switch (com) {
			case 1:
				if (c + 1 < col) {
					dice.toEast();
					c++;
					if (map[r][c] == 0) {
						map[r][c] = dice.floor;
					} else {
						dice.floor = map[r][c];
						map[r][c] = 0;
					}
					System.out.println(dice.celling);
				}
				break;

			case 2:
				if (c > 0) {
					dice.toWest();
					c--;
					if (map[r][c] == 0) {
						map[r][c] = dice.floor;
					} else {
						dice.floor = map[r][c];
						map[r][c] = 0;
					}
					System.out.println(dice.celling);
				}
				break;
			case 3:
				if (r > 0) {
					dice.toNorth();
					r--;
					if (map[r][c] == 0) {
						map[r][c] = dice.floor;
					} else {
						dice.floor = map[r][c];
						map[r][c] = 0;
					}
					System.out.println(dice.celling);
				}
				break;
			case 4:
				if (r + 1 < row) {
					dice.toSouth();
					r++;
					if (map[r][c] == 0) {
						map[r][c] = dice.floor;
					} else {
						dice.floor = map[r][c];
						map[r][c] = 0;
					}
					System.out.println(dice.celling);
				}
				break;
			}
		}
	}

	static class Dice {
		int up, down, right, left, celling, floor;

		void toEast() {
			int temp = right;
			right = celling;
			celling = left;
			left = floor;
			floor = temp;
		}

		void toWest() {
			int temp = left;
			left = celling;
			celling = right;
			right = floor;
			floor = temp;
		}

		void toSouth() {
			int temp = down;
			down = celling;
			celling = up;
			up = floor;
			floor = temp;
		}

		void toNorth() {
			int temp = up;
			up = celling;
			celling = down;
			down = floor;
			floor = temp;
		}
	}
}