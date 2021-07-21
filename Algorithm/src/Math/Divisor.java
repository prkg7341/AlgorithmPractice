package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Divisor {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int mid = n/2;
		
		int[] ar = new int[n];
		
		String[] input = br.readLine().split(" ");
		
		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(ar);
		
		if(n%2==0){
			bw.write(String.valueOf(ar[mid-1]*ar[mid]));
		}
		else{
			bw.write(String.valueOf(ar[mid]*ar[mid]));
		}
		bw.flush();
		bw.close();
	}
}
