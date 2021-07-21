package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moving {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);

		int[][] ar = new int[row+1][col+1];

		for(int i=1 ; i<=row ; i++){
			input = br.readLine().split(" ");
			for(int j=1 ; j<=col ; j++){
				ar[i][j] = Math.max(ar[i-1][j], ar[i][j-1])+Integer.parseInt(input[j-1]);
			}
		}
		System.out.println(ar[row][col]);
	}
}
