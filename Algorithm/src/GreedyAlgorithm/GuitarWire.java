package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuitarWire {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int minA = 1001;
		int minB = 1001;

		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			minA = Math.min(minA, Integer.parseInt(input[0]));
			minB = Math.min(minB, Integer.parseInt(input[1]));
		}

		int result = Math.min(minA*(n/6) + Math.min(minA, minB*(n%6)), minB*n);
		System.out.print(result);
	}
}