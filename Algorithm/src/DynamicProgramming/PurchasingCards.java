package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PurchasingCards {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] price = new int[n];

		int[] ar = new int[n+1];

		for(int i=0 ; i<n ; i++){
			price[i] = Integer.parseInt(input[i]);
		}

		ar[0] = 0;

		for(int i=1 ; i<=n ; i++){
			int max = Integer.MIN_VALUE;
			for(int j=0 ; j<i ; j++){
				max = Math.max(max, ar[j]+price[i-j-1]);
			}
			ar[i] = max;
		}
		System.out.println(ar[n]);
	}
}
