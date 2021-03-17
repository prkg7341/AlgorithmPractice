package TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2118 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[2*n+1];

		for(int i=1 ; i<=n ; i++) {
			int now = Integer.parseInt(br.readLine());
			ar[i] = ar[i-1] + now;
			ar[i+n] = now;
		}

		for(int i=n+1 ; i<ar.length ; i++) {
			ar[i] += ar[i-1];
		}

		int a = 0;
		int b = 1;
		int max = 0;

		while(max!=ar[n]/2 && a<=n) {			
			int now = ar[b]-ar[a];

			max = Math.max(max, Math.min(now, ar[n]-now));

			if(now*2>ar[n]) {
				a++;
			}
			else {
				b++;
			}
		}

		bw.write(Integer.toString(max));

		bw.flush();
	}
}
