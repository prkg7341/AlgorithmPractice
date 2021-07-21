package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ring {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		int[] ar = new int[n];
		
		String[] input = br.readLine().split(" ");
		
		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		for(int i=1 ; i<n ; i++){
			int max = Math.max(ar[0], ar[i]);
			int min = Math.min(ar[0], ar[i]);
			while(max%min!=0){
				int temp = min;
				min = max%min;
				max = temp;
			}
			int mc = min;
			sb.append(ar[0]/mc+"/"+ar[i]/mc+"\n");
		}
		
		bw.write(sb.toString());	
		bw.flush();
		bw.close();
	}
}
