package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());

			int[][] ar = new int[n][2];

			for(int i=0 ; i<n ; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());

				ar[i][0] = score;
				ar[i][1] = cal;
			}

			int[][] dp = new int[n+1][max+1];

			for(int i=1 ; i<=n ; i++) {
				int now_score = ar[i-1][0];
				int now_cal = ar[i-1][1];
				for(int j=1 ; j<=max ; j++) {
					if(j<now_cal) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-now_cal]+now_score);
					}
				}
			}
			System.out.printf("#%d %d\n", tt, dp[n][max]);
		}
	}	
}
