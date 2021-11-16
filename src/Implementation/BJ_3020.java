package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] suk = new int[n / 2];
		Integer[] jong = new Integer[n / 2];

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				suk[i / 2] = Integer.parseInt(br.readLine());
			else
				jong[i / 2] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(suk);
		Arrays.sort(jong, Collections.reverseOrder());

		int min = suk.length;
		int count = 2;

		int suk_index = 0;
		int jong_index = 0;

		for (int i = 2; i < h; i++) {
			while (suk_index < suk.length && suk[suk_index] < i) {
				suk_index++;
			}
			while (jong_index < jong.length && h - jong[jong_index] < i) {
				jong_index++;
			}

			int temp_min = suk.length - suk_index + jong_index;

			if (min > temp_min) {
				min = temp_min;
				count = 1;
			} else if (min == temp_min)
				count++;
		}

		System.out.print(min + " " + count);
	}
}