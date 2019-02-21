package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoMulNTiling {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n==1){
			System.out.println(1);
			return;
		}
		if(n==2){
			System.out.println(2);
			return;
		}

		int[] ar = new int[n];

		ar[0] = 1;
		ar[1] = 2;

		for(int i=2 ; i<ar.length ; i++){
			ar[i] = ar[i-2]+ar[i-1];
			if(ar[i]>=10007){
				ar[i]-=10007;
			}
		}
		System.out.println(ar[n-1]);
	}
}
