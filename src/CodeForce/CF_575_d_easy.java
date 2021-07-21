package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_575_d_easy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int len = Integer.parseInt(input[1]);

			char[] char_ar = br.readLine().toCharArray();
			int[] R = new int[n+1];
			int[] G = new int[n+1];
			int[] B = new int[n+1];

			for(int i=0 ; i<n ; i++) {
				char now = char_ar[i];
				switch(now) {
				case 'R':
					if(i%3==0) {
						R[i+1] = R[i];
						G[i+1] = G[i]+1;
						B[i+1] = B[i]+1;
					}
					else if(i%3==1) {
						R[i+1] = R[i]+1;
						G[i+1] = G[i]+1;
						B[i+1] = B[i];
					}
					else {
						R[i+1] = R[i]+1;
						G[i+1] = G[i];
						B[i+1] = B[i]+1;
					}
					break;

				case 'G':
					if(i%3==0) {
						R[i+1] = R[i]+1;
						G[i+1] = G[i];
						B[i+1] = B[i]+1;
					}
					else if(i%3==1) {
						R[i+1] = R[i];
						G[i+1] = G[i]+1;
						B[i+1] = B[i]+1;
					}
					else {
						R[i+1] = R[i]+1;
						G[i+1] = G[i]+1;
						B[i+1] = B[i];
					}
					break;

				case 'B':
					if(i%3==0) {
						R[i+1] = R[i]+1;
						G[i+1] = G[i]+1;
						B[i+1] = B[i];
					}
					else if(i%3==1) {
						R[i+1] = R[i]+1;
						G[i+1] = G[i];
						B[i+1] = B[i]+1;
					}
					else {
						R[i+1] = R[i];
						G[i+1] = G[i]+1;
						B[i+1] = B[i]+1;
					}
					break;
				}
			}

			int min = Integer.MAX_VALUE;
			for(int i=len ; i<=n ; i++) {
				min = Math.min(min, R[i]-R[i-len]);
				min = Math.min(min, G[i]-G[i-len]);
				min = Math.min(min, B[i]-B[i-len]);
			}
			sb.append(min).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}