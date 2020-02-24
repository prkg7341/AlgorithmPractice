package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11051_BinomialCoefficient2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		b = Math.min(a-b, b);

		if(b==0){
			System.out.println(1);
			return;
		}

		if(b==1){
			System.out.println(a);
			return;
		}

		int[][] dp = new int[a+1][a+1];

		for(int i=1 ; i<=a ; i++){
			dp[i][0] = 1;
		}
		for(int i=1 ; i<=a ; i++){
			dp[i][1] = i;
		}
		for(int i=2 ; i<=a ; i++){
			for(int j=2 ; j<=i ; j++){
				dp[i][j] = (dp[i-1][j-1]+dp[i-1][j])%10007;
			}
		}
		System.out.println(dp[a][b]);
	}
}
