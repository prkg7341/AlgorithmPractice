package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];
		int[] dp = new int[n];

		String[] input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
			dp[i] = 1;
		}
		int result = 1;
		for(int i=1 ; i<n ; i++){		
			for(int j=0 ; j<i ; j++){
				int max = dp[i];
				if(ar[j]<ar[i]){
					max = Math.max(max, dp[j]+1);
				}
				dp[i] = max;
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
