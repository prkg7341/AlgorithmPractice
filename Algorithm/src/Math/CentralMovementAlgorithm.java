package Math;

import java.util.Scanner;

public class CentralMovementAlgorithm {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n+1];
		ar[0] = 2;
		for(int i=1 ; i<n+1 ; i++){
			ar[i] = 2*ar[i-1] - 1;
		}
		
		System.out.println(ar[n]*ar[n]);
		
		sc.close();
	}
}
