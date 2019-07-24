package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a575 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			long a,b,c;
			String[] input = br.readLine().split(" ");
			a = Long.parseLong(input[0]);
			b = Long.parseLong(input[1]);
			c = Long.parseLong(input[2]);

			long sum = a+b+c;

			sb.append(sum/2).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
