package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SDS_2_2_2 {

	static int n;
	static int[][] ar;
	static int[][] dp;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine().split(" ")[0]);

		for(int tt=1 ; tt<=t ; tt++){

			n = Integer.parseInt(br.readLine());

			ar = new int[n][n];
			dp = new int[n][n];

			for(int i=0 ; i<n ; i++){
				String[] input = br.readLine().split(" ");
				for(int j=0 ; j<n ; j++){
					ar[i][j] = Integer.parseInt(input[j]);
				}
			}

			int max = 0;

			for(int i=0 ; i<n ; i++){
				for(int j=0 ; j<n ; j++){
					max = Math.max(max, dfs(i,j));
				}
			}

			sb.append("#").append(tt).append(" ").append(max+1).append(" \n");
		}
		System.out.print(sb.toString());
	}

	private static int dfs(int x, int y) {

		if(dp[x][y]==0){
			int max = 0;
			for(int i=0 ; i<4 ; i++){
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(newX>=0 && newY>=0 && newX<n && newY<n){
					if(ar[newX][newY]>ar[x][y]){
						max = Math.max(max, dfs(newX, newY)+1);
					}
				}
			}
			dp[x][y] = max;
			return max;
		}
		else{
			return dp[x][y];
		}
	}
}
