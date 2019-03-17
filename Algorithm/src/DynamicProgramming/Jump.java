package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Jump {

	static int n;
	static int[][] table;
	static long[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		table = new int[n][n];
		dp = new long[n][n];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++){
				table[i][j] = Integer.parseInt(input[j]);
			}
		}

		dfs(0,0);

		System.out.println(dp[0][0]);
		System.out.println(Arrays.deepToString(dp));
	}

	private static long dfs(int x, int y){

		if(x==n-1 && y==n-1){
			return 1;
		}

		if(table[x][y]==0){
			return 0;
		}

		if(dp[x][y]==0){
			if(x+table[x][y]<n){
				dp[x][y] += dfs(x+table[x][y],y);
			}
			if(y+table[x][y]<n){
				dp[x][y] += dfs(x,y+table[x][y]);
			}
		}
		return dp[x][y];
	}
}
