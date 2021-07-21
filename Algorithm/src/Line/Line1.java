package Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Line1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		int c = (int) Math.pow(n, 0.5)+1;

		long result = 12345678;

		while(c>=1){
			if(n%c==0){
				result = Math.min(result, Math.abs(c-n/c));
			}
			c--;
		}
		System.out.print(result);
	}
}
