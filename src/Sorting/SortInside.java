package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SortInside {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		int[] ar = new int[input.length()];
		
		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(input.split("")[i]);
		}
		
		Arrays.sort(ar);
		
		for(int i=0 ; i<ar.length/2 ; i++){
			int temp = ar[i];
			ar[i] = ar[ar.length-1-i];
			ar[ar.length-1-i] = temp;
		}
			
		for(int i=0 ; i<ar.length ; i++){
			sb.append(ar[i]+"");
		}
			
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
