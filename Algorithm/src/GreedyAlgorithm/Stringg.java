package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stringg {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		char[] a = input[0].toCharArray();
		char[] b = input[1].toCharArray();

		int minus = b.length-a.length;

		int min = 123;

		for(int i=0 ; i<=minus ; i++){
			int count=0;
			for(int j=i ; j<i+a.length ; j++){
				if(a[j-i]!=b[j]) count++;
			}
			min = Math.min(min, count);
		}
		System.out.print(min);
	}
}