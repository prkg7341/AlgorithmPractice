package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1904_Tile01 {

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

		int[] ar = new int[n+1];

		ar[1] = 1;
		ar[2] = 2;

		for(int i=3 ; i<=n ; i++){
			ar[i] = (ar[i-1]+ar[i-2])%15746;
		}
		System.out.println(ar[n]);
	}
}
