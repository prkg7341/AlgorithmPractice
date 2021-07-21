package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_1292 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);

		int[] ar = new int[10001];

		int num = 1;

		ar[1] = 1;

		for(int i=2 ; i<ar.length ; i++) {
			num++;
			for(int j=0 ; j<num ; j++) {
				ar[i++] = ar[i-2]+num;
				if(i==ar.length) break;
			}
			i--;
		}
		
		bw.write(String.valueOf(ar[end]-ar[start-1]));

		bw.flush();
	}
}
