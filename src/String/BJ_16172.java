package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16172 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();

		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (input[i] > '9' || input[i] < '0')
				sBuilder.append(input[i]);
		}

		char[] string = sBuilder.toString().toCharArray();

		int index1 = 1, index2 = 0;
		int[] pi = new int[pattern.length];

		while (index1 < pattern.length) {
			if (pattern[index1] == pattern[index2]) {
				pi[index1++] = ++index2;
			} else if (index2 == 0) {
				index1++;
			} else {
				index2 = pi[index2 - 1];
			}
		}

		index1 = 0;
		index2 = 0;

		while (index1 < string.length) {
			if (string[index1] == pattern[index2]) {
				index1++;
				if (++index2 == pattern.length) {
					System.out.println(1);
					return;
				}
			} else if (index2 == 0) {
				index1++;
			} else {
				index2 = pi[index2-1];
			}
		}
		System.out.println(0);
	}
}