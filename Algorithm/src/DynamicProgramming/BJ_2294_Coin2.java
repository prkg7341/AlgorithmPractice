package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2294_Coin2 {

	static int impossible = 123456;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);

		int k = Integer.parseInt(input[1]);

		int[][] dp = new int[n+1][k+1];

		for(int i=1 ; i<=k ; i++){
			dp[0][i] = impossible;
		}

		for(int i=1 ; i<=n ; i++){
			int now = Integer.parseInt(br.readLine());

			for(int j=1 ; j<=k ; j++){
				if(j<now){
					dp[i][j] = dp[i-1][j];
				}
				else{
					dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-now]);
				}
			}
		}
		if(dp[n][k]==impossible){
			System.out.println(-1);
		}
		else{
			System.out.println(dp[n][k]);
		}
	}
}
