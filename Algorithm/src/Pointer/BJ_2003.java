package Pointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2003 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);

		int[] ar = new int[n+1];

		input = br.readLine().split(" ");

		for(int i=1 ; i<=n ; i++) {
			int now = Integer.parseInt(input[i-1]);
			ar[i] = ar[i-1] + now;
		}

		int a = 0;
		int b = 1;
		int count = 0;

		while(b<=n) {			
			int now = ar[b] - ar[a];

			if(now==num) {				
				count++;
				a++; b++;
			}
			else if(now>num) a++;			
			else b++;
		}

		bw.write(Integer.toString(count));

		bw.flush();
	}
}
