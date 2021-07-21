package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompanyInvestment {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int money = Integer.parseInt(input[0]);
		int com = Integer.parseInt(input[1]);

		int[][] table = new int[money+1][com+1];

		for(int i=1 ; i<=money ; i++){
			input = br.readLine().split(" ");

			for(int j=1 ; j<=com ; j++){
				table[i][j] = Integer.parseInt(input[j]);
			}
		}

		int[][][] dp = new int[money+1][com+1][com+1];

		for(int i=1 ; i<=com ; i++){			
			for(int j=1 ; j<=money ; j++){
				for(int k=0 ; k<=j ; k++){
					if(dp[j][i][0]<dp[j-k][i-1][0]+table[k][i]){
						dp[j][i][0] = Math.max(dp[j][i][0], dp[j-k][i-1][0]+table[k][i]);
						for(int l=1 ; l<i ; l++){
							dp[j][i][l] = dp[j-k][i-1][l];
						}
						dp[j][i][i] = k;
					}
				}
			}
		}
		System.out.println(dp[money][com][0]);
		for(int i=1 ; i<=com ; i++){
			System.out.print(dp[money][com][i]+" ");
		}
	}
}
