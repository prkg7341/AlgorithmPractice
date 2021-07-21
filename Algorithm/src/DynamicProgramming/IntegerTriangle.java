package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerTriangle {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] ar = new int[n][n];
		
		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<=i ; j++){
				if(i==0){
					ar[i][j] = -Integer.parseInt(input[j]);
				}
				else{
					if(j==0){
						ar[i][j] = ar[i-1][j]-Integer.parseInt(input[j]);
					}
					else if(j==i){
						ar[i][j] = ar[i-1][j-1]-Integer.parseInt(input[j]);
					}
					else{
						ar[i][j] = Math.min(ar[i-1][j-1], ar[i-1][j])-Integer.parseInt(input[j]);
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0 ; i<n ; i++){
			min = Math.min(min, ar[n-1][i]);
		}
		System.out.println(-min);
	}
}
