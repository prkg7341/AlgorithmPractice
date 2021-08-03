package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1937{

	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][n];
		int[][] dp = new int[n][n];
		visit = new boolean[n][n];

		int max = 0;

		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++) {
				ar[i][j] = Integer.parseInt(input[j]);
			}
		}

		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(dp[i][j]==0) {
					dp[i][j] = dfs(ar,dp,i,j);
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max);
	}

	private static int dfs(int[][] ar, int[][] dp, int r, int c) {

		visit[r][c] = true;

		int[] m = new int[4];

		for(int i=0 ; i<4 ; i++) {
			int newR = r+dr[i];
			int newC = c+dc[i];

			if(newR<0 || newC<0 || newR==ar.length || newC==ar.length) continue;

			if(ar[newR][newC]>ar[r][c]) {
				if(visit[newR][newC]) {				
					m[i] = dp[newR][newC];
				}			
				else  {
					m[i] = dfs(ar,dp,newR,newC);
				}
			}
		}

		dp[r][c] = 1+max(m);

		return dp[r][c];
	}

	private static int max(int[] m) {
		int ret = 0;
		for(int i : m) ret = Math.max(ret, i);
		return ret;
	}
}