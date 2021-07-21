package SWM;

import java.util.Scanner;

public class SWM4 {
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] ar = new int[n][4];

		for(int i=0 ; i<n ; i++) {
			ar[i][0] = sc.nextInt();
		}

		int now = 0;
		int count = 1;
		int max = 0;

		while(ar[now][1]==0) {
			ar[now][1] = 1;
			now += ar[now][0];
			count++;
		}		
		max = Math.max(max, count);

		now = 1;
		count = 1;

		while(ar[now][2]==0) {
			ar[now][2] = 1;
			now += ar[now][0];
			count++;
		}		
		max = Math.max(max, count);

		now = 2;
		count = 1;

		while(ar[now][3]==0) {
			ar[now][3] = 1;
			now += ar[now][0];
			count++;
		}		
		max = Math.max(max, count);

		System.out.println(max);
	}
}
