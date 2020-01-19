package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10844_EasyNumofStairs {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n==1){
			System.out.println(9);
			return;
		}

		int[][] ar = new int[n][10];

		for(int i=1 ; i<=9 ; i++){
			ar[0][i] = 1;
		}

		for(int i=1 ; i<n ; i++){
			ar[i][0] = ar[i-1][1];
			ar[i][9] = ar[i-1][8];
			for(int j=1 ; j<=8 ; j++){
				ar[i][j] = (ar[i-1][j-1] + ar[i-1][j+1])%1000000000;
			}
		}
		int result=0;

		for(int i=0 ; i<=9 ; i++){
			result = (result+ar[n-1][i])%1000000000;
		}
		System.out.println(result);
	}
}
