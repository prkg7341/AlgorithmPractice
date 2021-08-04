package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] ar = new int[n+1][n+1];

			int max = 0;

			for(int i=1 ; i<=n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1 ; j<=n ; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken())+ar[i-1][j]+ar[i][j-1]-ar[i-1][j-1];
					if(i>=m && j>=m) {
						max = Math.max(max, ar[i][j]-ar[i-m][j]-ar[i][j-m]+ar[i-m][j-m]);
					}
				}
			}
			System.out.printf("#%d %d\n", tt, max);
		}
	}	
}
