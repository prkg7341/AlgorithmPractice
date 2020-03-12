package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_541_a {
	static int h0;
	static int w0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int w1,h1,w2,h2;

		w1 = Integer.parseInt(input[0]);
		h1 = Integer.parseInt(input[1]);
		w2 = Integer.parseInt(input[2]);
		h2 = Integer.parseInt(input[3]);

		h0 = h1+h2+2;
		w0 = w1+2;
		
		int result = h0*w0-h1*w1-h2*w2-(w1-w2)*h2;

		System.out.println(result);
	}
}
