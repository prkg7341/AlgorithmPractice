package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumOfAlphabet {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ar = new int[26];
		char[] input = br.readLine().toCharArray();

		for(int i=0 ; i<input.length ; i++){
			ar[input[i]-97]++;
		}
		for(int i : ar){
			System.out.print(i+" ");
		}
	}
}
