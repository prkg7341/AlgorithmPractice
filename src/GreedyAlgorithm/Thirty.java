package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thirty {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split("");

		int[] ar = new int[input.length];

		int sum = 0;
		boolean has = false;

		for(int i=0 ; i<input.length ; i++){
			ar[i] = Integer.parseInt(input[i]);
			sum += ar[i];
			if(ar[i]==0) has = true;
		}

		if(has && sum%3==0){
			Arrays.sort(ar);
			for(int i=ar.length-1 ; i>=0 ; i--){
				sb.append(ar[i]);
			}
			System.out.print(sb.toString());
		}
		else{
			System.out.print(-1);
		}
	}
}