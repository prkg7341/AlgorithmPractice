package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrdinaryKnapsack {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);

		int ww = Integer.parseInt(input[1]);

		int[][] table = new int[n+1][2];

		for(int i=1 ; i<=n ; i++){
			input = br.readLine().split(" ");

			int w = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);

			table[i][0] = w;
			table[i][1] = v;
		}

		int[][] dp = new int[n+1][ww+1];

		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<=ww ; j++){
				if(j<table[i][0]) 
					dp[i][j] = dp[i-1][j];
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-table[i][0]]+table[i][1]);
				}
			}
		}
		System.out.print(dp[n][ww]);
	}
}