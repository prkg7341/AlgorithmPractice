package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_14852 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n+1][2];

		ar[0][1] = 1;

		for(int i=1 ; i<=n ; i++) {
			ar[i][0] = (ar[i-1][0] + ar[i-1][1])%1000000007;
			ar[i][1] = 2*ar[i][0]%1000000007;
			try {
				ar[i][1] += ar[i-2][1];
				ar[i][1] %= 1000000007;
			}catch(Exception e) {

			}
		}

		bw.write(Integer.toString(ar[n][1]));

		bw.flush();
	}
}
