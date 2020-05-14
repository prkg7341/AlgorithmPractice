package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_11660 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] table = new int[n+1][n+1];

		for(int i=1 ; i<=n ; i++) {
			input = br.readLine().split(" ");
			for(int j=1 ; j<=n ; j++){
				int now = Integer.parseInt(input[j-1]);
				table[i][j] = table[i][j-1] + table[i-1][j] - table[i-1][j-1] + now;
			}
		}

		for(int i=1 ; i<=m ; i++) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);

			bw.write((table[x2][y2]-table[x2][y1-1]-table[x1-1][y2]+table[x1-1][y1-1])+"\n");
		}

		bw.flush();
	}
}
