package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1405{

	static double[] percent;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static double simple = 0.0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		double east = (double)Integer.parseInt(st.nextToken())/100.0;
		double west = (double)Integer.parseInt(st.nextToken())/100.0;
		double south = (double)Integer.parseInt(st.nextToken())/100.0;
		double north = (double)Integer.parseInt(st.nextToken())/100.0;

		percent = new double[] {east, west, south, north};

		int l = 2*n+1;
		boolean[][] visit = new boolean[l][l];

		int r = n;
		int c = n;
		visit[r][c] = true;

		btrk(visit, r, c, 0, 1.0);

		System.out.println(simple);
	}

	private static void btrk(boolean[][] visit, int r, int c, int depth, double p) {

		if(depth==visit.length/2) {
			simple += p;
			return;
		}

		for(int i=0 ; i<4 ; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];

			if(!visit[nr][nc]) {
				visit[r][c] = true;
				btrk(visit, nr, nc, depth+1, p*percent[i]);
				visit[r][c] = false;
			}
		}
	}
}