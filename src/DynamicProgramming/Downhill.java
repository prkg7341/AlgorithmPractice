package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Downhill {

	static int[][] ar;
	static int[][] dp;
	static int col;
	static int row;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		col = Integer.parseInt(input[0]);
		row = Integer.parseInt(input[1]);

		ar = new int[col][row];
		dp = new int[col][row];

		for(int i=0 ; i<col ; i++){
			input = br.readLine().split(" ");
			for(int j=0 ; j<row ; j++){
				ar[i][j] = Integer.parseInt(input[j]);
				dp[i][j] = -1;
			}		
		}
		int result = dfs(0,0);
		System.out.println(result);
	}

	private static int dfs(int x, int y) {
		if(x==col-1 && y==row-1){
			return 1;
		}
		if(dp[x][y]==-1){
			dp[x][y] = 0;
			for(int i=0 ; i<4 ; i++){
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(newX==-1 || newY==-1 || newX==col || newY==row) continue;
				int val = ar[newX][newY];
				if(val<ar[x][y]){
					dp[x][y] += dfs(newX,newY);
				}
			}
		}

		return dp[x][y];
	}
}
