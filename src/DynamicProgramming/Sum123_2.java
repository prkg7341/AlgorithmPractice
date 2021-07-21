package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum123_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[11][3];

		ar[1][0] = 1;

		for(int i=2 ; i<=10 ; i++){
			ar[i][0] = ar[i-1][0]+ar[i-1][1]+ar[i-1][2];
			ar[i][1] = ar[i-1][0];
			ar[i][2] = ar[i-1][1];
		}

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(br.readLine());
			System.out.println(ar[now][0]+ar[now][1]+ar[now][2]);
		}
	}
}
