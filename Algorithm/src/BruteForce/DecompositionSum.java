package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecompositionSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i=n/2 ; i<n ; i++){

			int ii=i;

			int sum=ii;
			while(ii!=0){
				sum+=ii%10;
				ii /= 10;
			}

			if(sum==n){
				System.out.print(i);
				return;
			}
		}
		System.out.print(0);
	}
}
