package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10569 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			bw.write(String.valueOf(2-k+m));
			bw.write("\n");
		}
		
		bw.flush();
	}
}
