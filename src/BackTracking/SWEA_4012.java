package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_4012 {

	static int min;
	static int[][] ar;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			min = 987654321;

			int n = Integer.parseInt(br.readLine());

			ar = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer sTokenizer = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					ar[i][j] = Integer.parseInt(sTokenizer.nextToken());
				}
			}

			c(new ArrayList<Integer>(), new ArrayList<Integer>(), n, 0);

			System.out.printf("#%d %d\n", tt, min);
		}
	}

	private static void c(ArrayList<Integer> list1, ArrayList<Integer> list2, int n, int index) {
		if (index == n) {
			if (list1.size() < 2 || list2.size() < 2)
				return;

			int temp1 = 0;
			int temp2 = 0;

			for (int i = 0; i < list1.size(); i++) {
				for (int j = 0; j < list1.size(); j++) {
					temp1 += ar[list1.get(i)][list1.get(j)];
				}
			}

			for (int i = 0; i < list2.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
					temp2 += ar[list2.get(i)][list2.get(j)];
				}
			}

			min = Math.min(min, Math.abs(temp1 - temp2));
			return;
		}
		list1.add(index);
		c(list1, list2, n, index + 1);
		list1.remove(list1.size() - 1);
		list2.add(index);
		c(list1, list2, n, index + 1);
		list2.remove(list2.size() - 1);
	}
}
