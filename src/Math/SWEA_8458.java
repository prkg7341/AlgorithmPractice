package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine());

			int max = 0;
			boolean same = true;
			boolean odd = false;

			for (int i = 0; i < n; i++) {
				StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(stringTokenizer.nextToken());
				int b = Integer.parseInt(stringTokenizer.nextToken());

				int num = Math.abs(a) + Math.abs(b);

				max = Math.max(max, num);
				if (i == 0)
					odd = num % 2 == 1;
				else {
					boolean temp_odd = num % 2 == 1;
					if (odd ^ temp_odd)
						same = false;
				}
			}

			sb.append('#').append(tt).append(" ");
			if (same) {
				int sum = 0;
				for (int i = 0;; i++) {
					sum += i;
					if (sum >= max && (sum - max) % 2 == 0) {
						sb.append(i);
						break;
					}
				}
			} else {
				sb.append(-1);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
