package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2458 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int num = Integer.parseInt(stringTokenizer.nextToken());

		boolean[][] ar = new boolean[n][n];

		for (int i = 0; i < num; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());

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
		System.out.println(count);
	}
}
