package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());

		boolean[][] fw = new boolean[n][n];

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());

			int before = Integer.parseInt(st.nextToken()) - 1;
			int after = Integer.parseInt(st.nextToken()) - 1;

			fw[before][after] = true;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					fw[i][j] |= fw[i][k] & fw[k][j];
				}
			}
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			if (fw[a][b])
				System.out.println(-1);
			else if (fw[b][a])
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}