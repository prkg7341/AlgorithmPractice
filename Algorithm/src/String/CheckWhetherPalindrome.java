package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckWhetherPalindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		int mid = input.length/2;

		for(int i=0 ; i<mid ; i++){
			if(input[i]!=input[input.length-1-i]){
				System.out.println(0);
				return;
			}
		}
		System.out.print(1);
	}
}
