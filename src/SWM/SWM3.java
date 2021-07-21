package SWM;

import java.util.Scanner;

public class SWM3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int num = sc.nextInt();
		int now = sc.nextInt();
		
		int[] ar = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			ar[i] = sc.nextInt();
		}
		
		int min = 123456789;
		
		for(int i=0 ; i<n-num+1 ; i++) {
			if(ar[i]<=now && ar[i+num-1]>=now) min = Math.min(min, ar[i+num-1]-ar[i]);
		}
		System.out.println(min);
	}
}
