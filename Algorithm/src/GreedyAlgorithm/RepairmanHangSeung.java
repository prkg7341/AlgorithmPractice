package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepairmanHangSeung {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int l = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(ar);

		int count=0;

		for(int i=0 ; i<n ; i++){
			int index=i;
			for(int j=index+1 ; j<n ; j++){
				if(ar[j]-ar[index]<=l-1) i++;
			}
			count++;
		}
		System.out.print(count);
	}
}