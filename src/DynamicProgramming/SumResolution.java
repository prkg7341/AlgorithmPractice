package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumResolution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int[][] dp = new int[a+1][b+1];

		for(int i=1 ; i<=b ; i++){
			dp[0][i] = 1;
		}
		for(int i=1 ; i<=a ; i++){
			for(int j=1 ; j<=b ; j++){
				dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000;
			}
		}
		System.out.println(dp[a][b]);
	}
}
