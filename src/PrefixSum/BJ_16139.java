package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_16139 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = br.readLine().toCharArray();

		int[][] ar = new int[input.length+1][26];

		for(int i=1 ; i<=input.length ; i++) {
			int now = input[i-1]-'a';
			ar[i][now]++;
		}

		for(int i=1 ; i<=input.length ; i++) {
			for(int j=0 ; j<26 ; j++) {
				ar[i][j] += ar[i-1][j];
			}
		}

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++) {
			String[] temp = br.readLine().split(" ");

			int value = temp[0].charAt(0)-'a';
			int from = Integer.parseInt(temp[1]);
			int to = Integer.parseInt(temp[2])+1;

			bw.write(String.valueOf(ar[to][value]-ar[from][value])+"\n");
		}

		bw.flush();
	}
}
