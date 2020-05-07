package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_11969 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);

		int[][] ar = new int[n+1][3];

		for(int i=1 ; i<=n ; i++) {
			int now = Integer.parseInt(br.readLine());
			ar[i][now-1]++;
		}

		for(int i=1 ; i<=n ; i++) {
			for(int j=0 ; j<3 ; j++) {
				ar[i][j] += ar[i-1][j];
			}
		}

		for(int i=0 ; i<num ; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0])-1;
			int to = Integer.parseInt(input[1]);
			for(int j=0 ; j<3 ; j++) {
				bw.write(String.valueOf(ar[to][j]-ar[from][j])+" ");
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
