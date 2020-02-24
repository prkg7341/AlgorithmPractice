package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2576 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for(int i=0 ; i<7 ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num%2==1) {
				sum += num;
				min = Math.min(min, num);
			}
		}

		if(sum!=0) {
			bw.write(String.valueOf(sum));
			bw.write("\n");
			bw.write(String.valueOf(min));
		}
		else {
			bw.write(String.valueOf(-1));
		}
		bw.flush();
	}
}
