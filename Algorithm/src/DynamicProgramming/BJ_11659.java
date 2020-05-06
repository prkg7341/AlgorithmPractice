package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_11659 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int num = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int[] ar = new int[input.length+1];

		for(int i=1 ; i<ar.length ; i++) {
			ar[i] = ar[i-1] + Integer.parseInt(input[i-1]);
		}

		for(int i=0 ; i<num ; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			bw.write(String.valueOf(ar[to]-ar[from-1])+"\n");
		}

		bw.flush();
	}
}
