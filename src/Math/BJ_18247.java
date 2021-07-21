package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_18247 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<t ; i++) {
			String[] input = br.readLine().split(" ");

			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			if(n<12 || m<4) bw.write(-1+"\n");
			else {
				bw.write((11*m+4)+"\n");
			}
		}

		bw.flush();
	}
}
