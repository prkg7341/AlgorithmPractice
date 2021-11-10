package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] ar = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ar);

		long min = Long.MAX_VALUE;
		long n1 = 0, n2 = 0, n3 = 0;

		for (int fix = 0; fix < n - 2; fix++) {
			int left = fix + 1;
			int right = n - 1;

			while (left < right) {
				long temp = ar[fix] + ar[left] + ar[right];

				if (Math.abs(temp) < min) {
					min = Math.abs(temp);
					n1 = ar[fix];
					n2 = ar[left];
					n3 = ar[right];
				}

				if (temp > 0) {
					right--;
				} else if (temp < 0) {
					left++;
				} else {
					System.out.println(n1 + " " + n2 + " " + n3);
					return;
				}
			}
		}
		System.out.println(n1 + " " + n2 + " " + n3);
	}
}