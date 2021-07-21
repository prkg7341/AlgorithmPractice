package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bowl {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		int result = 0;
		char before = 0;

		for(int i=0 ; i<input.length ; i++){
			char now = input[i];
			if(before==now) result+=5;
			else result+=10;
			before = now;
		}
		System.out.print(result);
	}
}
