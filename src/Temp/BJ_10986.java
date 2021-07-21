package Temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10986 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		long[] extra = new long[m];
		long sum = 0;

		input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++) {
			long now = Long.parseLong(input[i]);
			sum += now;
			sum %= m;

			extra[(int)sum]++;
		}

		long answer = (extra[0]+1)*extra[0]/2;

		for(int i=1 ; i<extra.length ; i++){
			answer += extra[i]*(extra[i]-1)/2;
		}

		bw.write(String.valueOf(answer));

		bw.flush();
	}
}
