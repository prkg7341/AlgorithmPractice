package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int n = Integer.parseInt(br.readLine());

			int[][] ar = new int[n][3];

			String[] input = br.readLine().split(" ");
			for(int i=0 ; i<n ; i++){
				ar[i][1] = Integer.parseInt(input[i]);
			}
			input = br.readLine().split(" ");
			for(int i=0 ; i<n ; i++){
				ar[i][2] = Integer.parseInt(input[i]);
			}
			int[][] dp = new int[n+1][3];
			for(int i=1 ; i<=n ; i++){
				dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = Math.max(dp[i-1][0]+ar[i-1][1], dp[i-1][2]+ar[i-1][1]);
				dp[i][2] = Math.max(dp[i-1][0]+ar[i-1][2], dp[i-1][1]+ar[i-1][2]);
			}
			System.out.println(Math.max(dp[n][1], dp[n][2]));
		}
	}
}
