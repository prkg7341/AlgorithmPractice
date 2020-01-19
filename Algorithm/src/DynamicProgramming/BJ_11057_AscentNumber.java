package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11057_AscentNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n==1){
			System.out.println(10);
		}
		else{
			int[][] ar = new int[n][10];
			for(int i=0 ; i<=9 ; i++){
				ar[0][i] = 1;
			}
			for(int i=1 ; i<n ; i++){
				for(int j=0 ; j<=9 ; j++){
					for(int k=0 ; k<=j ; k++){
						ar[i][j] = (ar[i][j]+ar[i-1][k])%10007;
					}
				}
			}
			int result = 0;
			for(int i=0 ; i<=9 ; i++){
				result = (result+ar[n-1][i])%10007;
			}

			System.out.println(result);
		}
	}
}
