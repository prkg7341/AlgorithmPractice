package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_16507 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);
		int n = Integer.parseInt(input[2]);

		int[][] table = new int[row+1][col+1];

		for(int i=1 ; i<=row ; i++) {
			input = br.readLine().split(" ");
			for(int j=1 ; j<=col ; j++){
				int now = Integer.parseInt(input[j-1]);
				table[i][j] = table[i][j-1] + table[i-1][j] - table[i-1][j-1] + now;
			}
		}

		for(int i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			int r1 = Integer.parseInt(input[0]);
			int c1 = Integer.parseInt(input[1]);
			int r2 = Integer.parseInt(input[2]);
			int c2 = Integer.parseInt(input[3]);

			bw.write((table[r2][c2]-table[r2][c1-1]-table[r1-1][c2]+table[r1-1][c1-1])/(r2-r1+1)/(c2-c1+1)+"\n");
		}

		bw.flush();
	}
}
