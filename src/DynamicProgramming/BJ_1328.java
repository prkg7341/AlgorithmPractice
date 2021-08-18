package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1328 {

	static final int DIV = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		long[][][] dp = new long[n + 1][l + 1][r + 1];

		dp[1][1][1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= l; j++) {
				for (int k = 1; k <= r; k++) {
					dp[i][j][k] = (dp[i - 1][j - 1][k] %DIV
							+ dp[i - 1][j][k - 1] %DIV
							+ ((i - 2) * (dp[i - 1][j][k]%DIV))%DIV)%DIV;
//					dp[i][j][k] = ((dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]) % DIV
//							+ ((i - 2) * dp[i - 1][j][k]) % DIV % DIV) % DIV;
				}
			}
		}
		System.out.println(dp[n][l][r]);
	}
}