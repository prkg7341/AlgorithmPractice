package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecompositionSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n<10){
			if(n%2==0){
				System.out.print(n/2);
			}
			else {
				System.out.print(0);
			}
			return;
		}

		int nn = n;

		int temp = -1;

		while(nn!=0){
			nn /= 10;
			temp++;
		}

		for(int i=n-9*temp ; i<n ; i++){

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
