package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KevinBaconsSixStepRule {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] ar = new int[n][n];
		int[] sum = new int[n];
		int[] result = new int[2];

		for(int k=0 ; k<n ; k++){
			for(int i=0 ; i<n ; i++){
				if(k!=i) ar[k][i] = 123456;
			}
		}

		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			ar[a-1][b-1] = 1;
			ar[b-1][a-1] = 1;
		}
		for(int k=0 ; k<n ; k++){
			for(int i=0 ; i<n ; i++){
				for(int j=0 ; j<n ; j++){
					ar[i][j] = Math.min(ar[i][k] + ar[k][j], ar[i][j]);
				}
			}
		}
		result[0]=-1;
		result[1]=1234567;
		for(int k=0 ; k<n ; k++){
			for(int i=0 ; i<n ; i++){
				sum[k]+=ar[k][i];
			}
			if(sum[k]<result[1]){
				result[1] = sum[k];
				result[0] = k+1;
			}
		}
		System.out.println(result[0]);
	}	
}
