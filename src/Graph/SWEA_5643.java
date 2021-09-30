package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5643 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());

		for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine().trim());
			int num = Integer.parseInt(br.readLine().trim());

			boolean[][] ar = new boolean[n][n];

			for (int i = 0; i < num; i++) {
				StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(stringTokenizer.nextToken()) - 1;
				int to = Integer.parseInt(stringTokenizer.nextToken()) - 1;

				ar[from][to] = true;
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (i == j)
							ar[i][j] = true;
						else if (ar[i][j])
							continue;
						else {
							ar[i][j] = ar[i][k] && ar[k][j];
						}
					}
				}
			}
			int count = 0;
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (ar[i][j] || ar[j][i])
						continue;
					else
						continue loop;
				}
				count++;
			}
			System.out.printf("#%d %d\n", tt, count);
		}
	}
}
