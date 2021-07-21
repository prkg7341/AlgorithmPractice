package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] score = new int[n+1];

		for(int i=1 ; i<=n ; i++){
			score[i] = Integer.parseInt(br.readLine());
		}

		if(n==1){
			System.out.println(score[1]);
		}
		else if(n==2){
			System.out.println(score[1]+score[2]);
		}
		else if(n==3){
			System.out.println(Math.max(Math.max(score[1], score[2])+score[3], score[1]+score[2]));
		}
		else{
			int[] sum = new int[n+1];

			sum[1] = score[1];
			sum[2] = score[1]+score[2];
			sum[3] = Math.max(Math.max(score[1], score[2])+score[3], score[1]+score[2]);

			for(int i=4 ; i<=n ; i++){
				sum[i] = Math.max(Math.max(score[i]+sum[i-2], score[i]+score[i-1]+sum[i-3]), sum[i-1]);
			}
			System.out.println(sum[n]);
		}
	}
}
