package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n+1];

		for(int i=2 ; i<ar.length ; i++){
			int min = ar[i-1]+1;
			if(i%3==0){
				min = Math.min(min, ar[i/3]+1);
			}
			if(i%2==0){
				min = Math.min(min, ar[i/2]+1);				
			}
			ar[i] = min;
		}

		int result = ar[ar.length-1];

		System.out.println(result);
	}
}
