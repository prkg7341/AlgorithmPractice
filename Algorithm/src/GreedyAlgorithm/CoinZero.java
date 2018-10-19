package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CoinZero {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		
		input = br.readLine();
		
		int n = Integer.parseInt(input.split(" ")[0]);
		int k = Integer.parseInt(input.split(" ")[1]);
		int count = 0;
		
		int[] ar = new int[n];	
		
		for(int i=0 ; i<n ; i++){
			input = br.readLine();
			ar[i] = Integer.parseInt(input);
		}

		for(int i=n-1 ; i>=0 ; i--){
			count += k/ar[i];
			k = k%ar[i];
			if(k==0) break;
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
