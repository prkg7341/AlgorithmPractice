package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);

		if((v-a)%(a-b)==0){
			System.out.println((v-a)/(a-b)+1);
		}
		else{
			System.out.println((v-a)/(a-b)+2);
		}
	}	
}
