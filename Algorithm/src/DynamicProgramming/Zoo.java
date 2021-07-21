package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n][2];
		ar[0][0] = 1;
		ar[0][1] = 2;
		for(int i=1 ; i<n ; i++){
			ar[i][0] = (ar[i-1][0] + ar[i-1][1])%9901;
			ar[i][1] = (2*ar[i-1][0] + ar[i-1][1])%9901;
		}
		System.out.println((ar[n-1][0]+ar[n-1][1])%9901);
	}
}
