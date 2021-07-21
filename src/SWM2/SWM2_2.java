package SWM2;

import java.util.Scanner;

public class SWM2_2 {  
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] ar = new int[n];
		int[] visit = new int[n];

		for(int i=0 ; i<n ; i++) {
			ar[i] = sc.nextInt();
		}

		int max = 0;
		int count = 0;

		for(int i=0 ; i<n ; i++) {
			if(visit[i]>0) {
				continue;
			}

			int index = i;

			while(visit[index]<2) {
				visit[index]++;
				index += ar[index];
			}

			while(visit[index]<3) {
				visit[index]++;
				index += ar[index];
				count++;
			}

			max = Math.max(max, count);
			count = 0;
		}

		System.out.println(max);
	}
}