package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long[][] dp = new long[15][30];

		for(int j=1 ; j<=29 ; j++){
			dp[0][j] = 1;
		}

		for(int j=1 ; j<=29 ; j++){
			dp[1][j] = j;
		}

		for(int i=2 ; i<=14 ; i++){
			for(int j=i ; j<=29 ; j++){
				dp[i][j] = dp[i-1][j]*(j-i+1)/i;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");

			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			a = Math.min(a, b-a);

			System.out.println(dp[a][b]);

		}
	}

}
