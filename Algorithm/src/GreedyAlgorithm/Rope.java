package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Rope {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] ar = new int[n];
		
		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ar);
		
		int max = -1;
		
		for(int i=n-1 ; i>=0 ; i--){
			max = Integer.max(max, ar[i]*(n-i));
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
}
