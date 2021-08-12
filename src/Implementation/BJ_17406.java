package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17406 {

	static int min = 123456789;

	public static void main(String[] args) throws IOException {
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

		Command[] commands = new Command[n];
		int[] order = new int[n];
		boolean[] visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());

			int rr = Integer.parseInt(stringTokenizer.nextToken()) - 1;
			int cc = Integer.parseInt(stringTokenizer.nextToken()) - 1;
			int s = Integer.parseInt(stringTokenizer.nextToken());

			commands[i] = new Command(rr, cc, s);
		}

		p(ar, commands, order, visit, 0);
		System.out.println(min);
	}

	private static void p(int[][] ar, Command[] commands, int[] order, boolean[] visit, int depth) {

		if (depth == visit.length) {
			int[][] ar_ = new int[ar.length][ar[0].length];
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar[0].length; j++) {
					ar_[i][j] = ar[i][j];
				}
			}
			for (int i = 0; i < order.length; i++) {
				rotate(ar_, commands[order[i]]);
			}
			min = Math.min(min, getMin(ar_));
		}

		for (int i = 0; i < visit.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				order[depth] = i;
				p(ar, commands, order, visit, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void rotate(int[][] ar, Command command) {
		for (int i = 1; i <= command.s; i++) {
			int maxR = command.r + i;
			int minR = command.r - i;
			int maxC = command.c + i;
			int minC = command.c - i;

			int temp = ar[minR][minC];

			for (int x = minR + 1; x <= maxR; x++) {
				ar[x - 1][minC] = ar[x][minC];
			}
			for (int x = minC + 1; x <= maxC; x++) {
				ar[maxR][x - 1] = ar[maxR][x];
			}
			for (int x = maxR - 1; x >= minR; x--) {
				ar[x + 1][maxC] = ar[x][maxC];
			}
			for (int x = maxC - 1; x >= minC + 1; x--) {
				ar[minR][x + 1] = ar[minR][x];
			}
			ar[minR][minC + 1] = temp;
			// min = Math.min(min, getMin(ar));
		}
	}

	private static int getMin(int[][] ar) {
		int ret = 123456789;
		for (int[] temp : ar) {
			int sum = 0;
			for (int i : temp)
				sum += i;
			ret = Math.min(ret, sum);
		}
		return ret;
	}

	static class Command {
		int r, c, s;

		public Command(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}