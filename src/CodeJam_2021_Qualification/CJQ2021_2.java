package CodeJam_2021_Qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CJQ2021_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {

			bw.write("Case #");
			bw.write(Integer.toString(tt));
			bw.write(": ");

			String[] input = br.readLine().split(" ");

			int X = Integer.parseInt(input[0]);
			int Y = Integer.parseInt(input[1]);
			
			int sum = 0;
			
			char[] ar = input[2].toCharArray();
			
			char before = ar[0];
			
			for(int i=1 ; i<ar.length ; i++) {
				char now = ar[i];
				if(now=='?') continue;
				if(before=='?') before = now;
				else if(now!=before) {
					if(now=='C') {
						sum += Y;
					}
					else {
						sum += X;
					}
					before = now;
				}
			}
			
			bw.write(Integer.toString(sum));
			bw.write("\n");
		}

		bw.flush();
	}
}
