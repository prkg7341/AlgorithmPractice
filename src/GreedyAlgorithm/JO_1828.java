package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			int min = Integer.parseInt(stringTokenizer.nextToken());
			int max = Integer.parseInt(stringTokenizer.nextToken());

			ar[i][0] = min;
			ar[i][1] = max;
		}

		Arrays.sort(ar, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int max = -270;
		int count = 0;

		for (int i = 0; i < n; i++) {
			int now_max = ar[i][1];
			int now_min = ar[i][0];
			if (now_min > max) {
				count++;
				max = now_max;
			}
		}
		System.out.println(count);
	}
}
