package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofSquares {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int t = 1;

		int[] ar = new int[n+1];

		for(int i=1 ; i<=n ; i++){
			if(i==t*t){
				ar[i] = 1;
				t++;
				continue;
			}
			int min = ar[i-1]+1;
			for(int j=1 ; j*j<=i ; j++){
				min = Math.min(min, ar[i-j*j]+1);
			}
			ar[i] = min;
		}
		System.out.println(ar[n]);
	}
}
