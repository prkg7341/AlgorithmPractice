package BitMask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar[i][0] = Integer.parseInt(st.nextToken());
			ar[i][1] = Integer.parseInt(st.nextToken());
		}

		int min = 123456789;

		for (int i = 1; i < 1 << (n); i++) {
			int s = 1;
			int b = 0;
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) == 1 << j) {
					s *= ar[j][0];
					b += ar[j][1];
				}
			}
			min = Math.min(min, Math.abs(s - b));
		}
		System.out.println(min);
	}
}