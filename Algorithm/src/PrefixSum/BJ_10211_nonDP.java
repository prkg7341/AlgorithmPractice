package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10211_nonDP {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");

			int[] ar = new int[n+1];

			for(int i=0 ; i<input.length ; i++) {
				ar[i+1] = ar[i]+Integer.parseInt(input[i]);		
			}

			int max = Integer.MIN_VALUE;

			for(int i=1 ; i<ar.length ; i++) {
				for(int j=0 ; j<i ; j++) {
					max = Math.max(max, ar[i]-ar[j]);
				}
			}
			bw.write(max+"\n");
		}

		bw.flush();
	}
}
