package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillingTile {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n==2){
			System.out.println(3);
			return;
		}

		if(n%2!=0){
			System.out.println(0);
			return;
		}

		int[][] ar = new int[n/2+1][2];

		ar[1][0] = 3;
		ar[1][1] = 2;

		for(int i=2 ; i<ar.length ; i++){
			ar[i][0] = ar[i-1][0]*3+ar[i-1][1];
			ar[i][1] = ar[i-1][0]*2+ar[i-1][1];
		}
		System.out.println(ar[ar.length-1][0]);
	}
}
