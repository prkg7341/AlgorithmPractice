package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_7465 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(stringTokenizer.nextToken());
			int num = Integer.parseInt(stringTokenizer.nextToken());

			int[] ar = new int[n];

			Arrays.fill(ar, -1);

			for (int i = 0; i < num; i++) {
				stringTokenizer = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
				int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;

				union(ar, a, b);
			}

			int count = 0;

			for (int i : ar) {
				if (i < 0)
					count++;
			}
			System.out.printf("#%d %d\n", tt, count);
		}
	}

	private static void union(int[] ar, int a, int b) {
		a = find(ar, a);
		b = find(ar, b);
		if (ar[a] == ar[b] && a != b) {
			ar[a] += ar[b];
			ar[b] = a;
		} else if (ar[a] < ar[b]) {
			ar[a] += ar[b];
			ar[b] = a;
		} else if (ar[a] > ar[b]) {
			ar[b] += ar[a];
			ar[a] = b;
		}
	}

	private static int find(int[] ar, int a) {
		if (ar[a] < 0)
			return a;
		return ar[a] = find(ar, ar[a]);
	}
}
