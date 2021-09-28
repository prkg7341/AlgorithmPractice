package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		int length = input.length;

		int max = 0;

		for (int i = 1; i < length; i++) {
			int temp = 0;
			for (int j = 0; i + j < length; j++) {
				if (input[i + j] == input[j])
					max = Math.max(max, ++temp);
				else {
					temp = 0;
				}
			}
		}
		System.out.println(max);
	}
}