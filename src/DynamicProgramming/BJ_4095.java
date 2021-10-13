package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (r * c == 0)
				break;

			int[][] ar = new int[r + 1][c + 1];

			int max = 0;

			for (int i = 1; i <= r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= c; j++) {
					int now = Integer.parseInt(st.nextToken());

					if (now == 1) {
						ar[i][j] = Math.min(Math.min(ar[i - 1][j], ar[i][j - 1]), ar[i - 1][j - 1]) + 1;
						max = Math.max(max, ar[i][j]);
					}
				}
			}
			System.out.println(max);
		}
	}
}