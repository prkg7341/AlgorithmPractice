package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		int[][] ar = new int[n+1][k+1];

		for(int i=1 ; i<=n ; i++){
			int now = Integer.parseInt(br.readLine());
			ar[i][0] = 1;
			for(int j=1 ; j<=k ; j++){
				if(j<now){
					ar[i][j] = ar[i-1][j];
				}
				else{
					ar[i][j] = ar[i-1][j]+ar[i][j-now];
				}
			}
		}
		System.out.println(ar[n][k]);
	}
}
