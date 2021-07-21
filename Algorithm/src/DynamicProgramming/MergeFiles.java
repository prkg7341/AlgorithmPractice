package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeFiles {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int n = Integer.parseInt(br.readLine());
			int[] sizes = new int[n+1];
			int[][] dp = new int[n+1][n+1];

			String[] input = br.readLine().split(" ");

			for(int i=0 ; i<n ; i++){
				sizes[i+1] = sizes[i]+Integer.parseInt(input[i]);
			}

			for(int i=n-1 ; i>=1 ; i--){
				for(int j=i+1 ; j<=n ; j++){
					int min = Integer.MAX_VALUE;
					for(int k=i ; k<j ; k++){
						min = Math.min(min, dp[i][k]+dp[k+1][j]);
					}
					dp[i][j] = min+sizes[j]-sizes[i-1];
				}
			}
			sb.append(dp[1][n]).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}