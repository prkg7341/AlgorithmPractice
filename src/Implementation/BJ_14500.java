package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14500{

	static int[] dr = {0,0,1,-1};
	static int[] dc = {-1,1,0,0};

	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);

		int[][] ar = new int[r+2][c+2];

		visit = new boolean[r+2][c+2];

		for(int i=1 ; i<=r ; i++) {
			input = br.readLine().split(" ");
			for(int j=1 ; j<=c ; j++) {
				ar[i][j] = Integer.parseInt(input[j-1]);
			}
		}

		int max = 0;

		for(int i=1 ; i<=r ; i++) {
			for(int j=1 ; j<=c ; j++) {				
				visit[i][j] = true;
				max = Math.max(max, dfs(ar, i, j, 1));
				visit[i][j] = false;
			}
		}

		for(int i=1 ; i<r ; i++) {
			for(int j=1 ; j<c ; j++) {
				max = Math.max(max, get(ar,i,j));
			}
		}
		System.out.println(max);
	}

	private static int get(int[][] ar, int r, int c) {

		int ret = ar[r][c];

		int min = 123456;

		for(int i=0 ; i<4 ; i++) {
			int now = ar[r+dr[i]][c+dc[i]];
			min = Math.min(min, now);
			ret += now;
		}

		ret -= min;

		return ret;
	}

	private static int dfs(int[][] ar, int r, int c, int depth) {

		if(depth==4) {
			return ar[r][c];
		}

		int ret = 0;

		for(int i=0 ; i<4 ; i++) {
			int newR = r+dr[i];
			int newC = c+dc[i];

			if(newR>=0 && newR<ar.length && newC>=0 && newC<ar[0].length) {
				if(!visit[newR][newC]) {
					visit[newR][newC] = true;
					ret = Math.max(ret, dfs(ar,newR,newC,depth+1));
					visit[newR][newC] = false;
				}
			}
		}

		return ret+ar[r][c];
	}
}