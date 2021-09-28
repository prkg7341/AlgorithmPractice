package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15993 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int div = 1000000009;

		int[][] ar = new int[100001][2];

		ar[1][1] = 1;
		ar[2][1] = 1;
		ar[2][0] = 1;
		ar[3][0] = 2;
		ar[3][1] = 2;

		for (int i = 4; i < ar.length; i++) {
			ar[i][0] = ((ar[i - 3][1] + ar[i - 2][1]) % div + ar[i - 1][1]) % div;
			ar[i][1] = ((ar[i - 3][0] + ar[i - 2][0]) % div + ar[i - 1][0]) % div;
		}

		for (int tt = 0; tt < t; tt++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(ar[n][1] + " " + ar[n][0]);
		}
	}
}