package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_560_c {

	static int count = 0;

	static String input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		input = br.readLine();

		check();

		System.out.println(count);
		System.out.print(input);
	}

	private static void check() {
		if(input.length()%2==0){
			for(int i=0 ; i<input.length() ; i+=2){
				if(input.charAt(i)==input.charAt(i+1)){
					input = input.substring(0,i)+input.substring(i+1, input.length());
					count++;
					check();
					return;
				}
			}
		}
		else{
			count++;
			if(input.length()==1) {
				input = "";
				return;
			}
			for(int i=0 ; i<input.length()-2 ; i+=2){
				if(input.charAt(i)==input.charAt(i+1)){
					input = input.substring(0,i)+input.substring(i+1, input.length());
					check();
					return;
				}
			}
			input = input.substring(0, input.length()-1);
		}
	}
}