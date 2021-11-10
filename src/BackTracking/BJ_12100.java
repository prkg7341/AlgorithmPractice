package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12100 {

	static int[][] ar;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ar = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, ar[i][j]);
			}
		}

		btrk("", 0);

		System.out.println(max);
	}

	private static void btrk(String path, int depth) {
		if (depth == 5) {
			return;
		}		
//if(max==32) return;
		int[][] save = copyof(ar);

		if (left()) {
//			System.out.println(path+"left");
//			for(int[] temp : ar) {
//				for(int num : temp) System.out.print(num+" ");
//				System.out.println();
//			}
//			System.out.println();
			btrk(path + "left ", depth + 1);
			ar = copyof(save);
		}
		if (right()) {
//			System.out.println(path+"right");
//			for(int[] temp : ar) {
//				for(int num : temp) System.out.print(num+" ");
//				System.out.println();
//			}
//			System.out.println();
			btrk(path + "right ", depth + 1);
			ar = copyof(save);
		}
		if (up()) {
//			System.out.println(path+"up");
//			for(int[] temp : ar) {
//				for(int num : temp) System.out.print(num+" ");
//				System.out.println();
//			}
//			System.out.println();
			btrk(path + "up ", depth + 1);
			ar = copyof(save);
		}
		if (down()) {
//			System.out.println(path+"down");
//			for(int[] temp : ar) {
//				for(int num : temp) System.out.print(num+" ");
//				System.out.println();
//			}
//			System.out.println();
			btrk(path + "down ", depth + 1);
			ar = copyof(save);
		}
	}

	private static boolean down() {
		boolean changed = false;
		boolean[][] visit = new boolean[ar.length][ar.length];
		for (int col = 0; col < ar.length; col++) {
			int row_index = ar.length - 1;
			for (int row = ar.length - 2; row >= 0; row--) {
				if (ar[row][col] == 0)
					continue;

				int temp = ar[row][col];
				ar[row][col] = 0;
				if (!visit[row_index][col] && temp == ar[row_index][col]) {
					ar[row_index][col] *= 2;
					max = Math.max(max, ar[row_index][col]);

					visit[row_index][col] = true;
					changed = true;
				} else {
					if (ar[row_index][col] > 0)
						row_index--;
					if (row != row_index) {
						changed = true;
					}
					ar[row_index][col] = temp;
				}
			}
		}

		return changed;
	}

	private static boolean up() {
		boolean changed = false;
		boolean[][] visit = new boolean[ar.length][ar.length];
		for (int col = 0; col < ar.length; col++) {
			int row_index = 0;
			for (int row = 1; row < ar.length; row++) {
				if (ar[row][col] == 0)
					continue;

				int temp = ar[row][col];
				ar[row][col] = 0;
				if (!visit[row_index][col] && temp == ar[row_index][col]) {
					ar[row_index][col] *= 2;
					max = Math.max(max, ar[row_index][col]);

					visit[row_index][col] = true;
					changed = true;
				} else {
					if (ar[row_index][col] > 0)
						row_index++;
					if (row != row_index) {
						changed = true;
					}
					ar[row_index][col] = temp;
				}
			}
		}

		return changed;
	}

	private static boolean right() {
		boolean changed = false;
		boolean[][] visit = new boolean[ar.length][ar.length];
		for (int row = 0; row < ar.length; row++) {
			int col_index = ar.length - 1;
			for (int col = ar.length - 2; col >= 0; col--) {
				if (ar[row][col] == 0)
					continue;

				int temp = ar[row][col];
				ar[row][col] = 0;
				if (!visit[row][col_index] && temp == ar[row][col_index]) {
					ar[row][col_index] *= 2;
					max = Math.max(max, ar[row][col_index]);

					visit[row][col_index] = true;
					changed = true;
				} else {
					if (ar[row][col_index] > 0)
						col_index--;
					if (col != col_index) {
						changed = true;
					}
					ar[row][col_index] = temp;
				}
			}
		}

		return changed;
	}

	private static boolean left() {
		boolean changed = false;
		boolean[][] visit = new boolean[ar.length][ar.length];
		for (int row = 0; row < ar.length; row++) {
			int col_index = 0;
			for (int col = 1; col < ar.length; col++) {
				if (ar[row][col] == 0)
					continue;

				int temp = ar[row][col];
				ar[row][col] = 0;
				if (!visit[row][col_index] && temp == ar[row][col_index]) {
					ar[row][col_index] *= 2;
					max = Math.max(max, ar[row][col_index]);

					visit[row][col_index] = true;
					changed = true;
				} else {
					if (ar[row][col_index] > 0)
						col_index++;
					if (col != col_index) {
						changed = true;
					}
					ar[row][col_index] = temp;
				}
			}
		}

		return changed;
	}

	private static int[][] copyof(int[][] ar) {
		int[][] ret = new int[ar.length][ar.length];

		for (int i = 0; i < ar.length; i++) {
			ret[i] = ar[i].clone();
		}
		return ret;
	}
}