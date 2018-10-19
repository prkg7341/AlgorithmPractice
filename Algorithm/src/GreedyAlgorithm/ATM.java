package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ATM {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		String input = br.readLine();
		
		int[] ar = new int[n];
		
		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input.split(" ")[i]);
		}
		
		Arrays.sort(ar);
		
		int sum=0;
		
		for(int i=0 ; i<n ; i++){
			sum += (n-i)*ar[i];
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}
}
