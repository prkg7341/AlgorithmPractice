package Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Class {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] ar = new int[8];
		String line = br.readLine();
		String[] split = line.split(" ");
		String result;
		boolean tf = true;
		int[] arp = new int[ar.length];

		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(split[i]);
			arp[i] = ar[i];
		}
		
		Arrays.sort(ar);			

		for(int i=0 ; i<ar.length ; i++){
			if(ar[i] != arp[i]){
				tf = false;
			}
		}
		
		if(tf){
			result = "ascending";
		}

		else{
			tf=true;
			reverseSort(ar);
			
			for(int i=0 ; i<ar.length ; i++){
				if(ar[i] != arp[i]){
					tf = false;
				}
			}			

			if(tf){
				result = "descending";
			}

			else{
				result = "mixed";
			}
		}

		bw.write(result);
		bw.flush();
		bw.close();
	}

	private static void reverseSort(int[] ar) {

		int mid = ar.length/2-1;
		int temp;

		for(int i=0 ; i<=mid ; i++){
			temp = ar[i];
			ar[i] = ar[ar.length-1-i];
			ar[ar.length-1-i] = temp;
		}

	}

}
