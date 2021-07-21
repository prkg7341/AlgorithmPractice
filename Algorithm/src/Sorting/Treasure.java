package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Treasure {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;

		int n = Integer.parseInt(br.readLine());

		int[] ar1 = new int[n];
		int[] ar2 = new int[n];

		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			ar1[i] = Integer.parseInt(s1[i]);
		}
		for(int i=0 ; i<n ; i++){
			ar2[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		for(int i=0 ; i<n ; i++){
			sum += ar1[i]*ar2[n-1-i];
		}
		System.out.println(sum);
	}
}
