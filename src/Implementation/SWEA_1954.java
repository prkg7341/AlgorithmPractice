package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		// 동남서북
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};

		for(int tt=1 ; tt<=t ; tt++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==1) {
				System.out.println("#1");
				System.out.println(1);
				continue;
			}

			int[][] ar = new int[n][n];
			boolean[][] visit = new boolean[n][n];

			int r=0, c=0, d=0, count=0;

			while(!visit[r][c]) {				
				ar[r][c] = ++count;
				visit[r][c] = true;

				if(r+dr[d]>=n || r+dr[d]<0 || c+dc[d]>=n || c+dc[d]<0 || visit[r+dr[d]][c+dc[d]]) {
					d = (d+1)%4;
				}

				r += dr[d]; c+=dc[d];
			}

			System.out.println("#"+tt);
			for(int i=0 ; i<n ; i++) {
				for(int num : ar[i]) System.out.print(num+" ");
				System.out.println();
			}
		}		
	}	
}
