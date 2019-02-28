package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBStreet {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] ar = new int[n+1][3];

		for(int i=1 ; i<=n ; i++){
			String[] input = br.readLine().split(" ");

			ar[i][0] = Math.min(ar[i-1][1], ar[i-1][2]) + Integer.parseInt(input[0]);
			ar[i][1] = Math.min(ar[i-1][0], ar[i-1][2]) + Integer.parseInt(input[1]);
			ar[i][2] = Math.min(ar[i-1][1], ar[i-1][0]) + Integer.parseInt(input[2]);
		}
		int min = Math.min(ar[n][0], Math.min(ar[n][1], ar[n][2]));
		System.out.println(min);
	}
}
