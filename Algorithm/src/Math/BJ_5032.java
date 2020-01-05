package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_5032 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int now = Integer.parseInt(input[0]);
		int add = now + Integer.parseInt(input[1]);
		int price = Integer.parseInt(input[2]);

		int result = 0;

		while(add>=price) {
			result += add/price;
			add = add/price + add%price;
		}

		bw.write(String.valueOf(result));

		bw.flush();
	}
}
