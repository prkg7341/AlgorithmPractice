package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11582 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			Arrays.sort(ar, i * (n / num), (i + 1) * (n / num));
		}
		StringBuilder sb = new StringBuilder();
		for (int i : ar)
			sb.append(i).append(" ");
		System.out.println(sb);
	}
}