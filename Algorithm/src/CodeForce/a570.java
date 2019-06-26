package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a570 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int n = Integer.parseInt(input);

		char[] ar = input.toCharArray();

		int sum = 0;

		for(int i=0 ; i<ar.length ; i++){
			sum += (int)ar[i]-48;
		}

		while(true){
			if(sum%4==0){
				break;
			}
			n++;
			input = String.valueOf(n);
			ar = input.toCharArray();
			sum = 0;
			for(int i=0 ; i<ar.length ; i++){
				sum += (int)ar[i]-48;
			}
		}
		System.out.print(n);
	}
}
