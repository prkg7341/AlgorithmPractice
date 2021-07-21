package CodeJam_2021_Qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CJQ2021_1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {

			bw.write("Case #");
			bw.write(Integer.toString(tt));
			bw.write(": ");

			int n = Integer.parseInt(br.readLine());

			int[] ar = new int[n];

			String[] input = br.readLine().split(" ");

			for(int i=0 ; i<n ; i++) {
				ar[i] = Integer.parseInt(input[i]);
			}

			int sum = 0;

			for(int i=0 ; i<n-1 ; i++) {				
				int j = i;
				j = find(ar, i+1);			
				swap(ar, i, j);
				sum += j-i+1;
			}

			bw.write(Integer.toString(sum));
			bw.write("\n");
		}

		bw.flush();
	}

	private static void swap(int[] ar, int a, int b) {		
		while(a<=b) {
			int temp = ar[b];
			ar[b] = ar[a];
			ar[a] = temp;
			a++; b--;
		}
	}

	private static int find(int[] ar, int index) {
		for(int i=index ; i<ar.length ; i++) {
			if(ar[i]==index) {
				return i;
			}
		}
		return index-1;
	}
}
