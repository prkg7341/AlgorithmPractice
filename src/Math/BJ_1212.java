package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1212 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split("");

		for(int i=0 ; i<input.length ; i++) {
			int now = Integer.parseInt(input[i]);
			String st = Integer.toBinaryString(now);
			if(i!=0) {
				while(st.length()<3) st  = 0+st;
			}
			bw.write(st);
		}

		bw.flush();
	}
}
