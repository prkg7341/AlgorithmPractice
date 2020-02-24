package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_3034 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int w = Integer.parseInt(input[1]);
		int h = Integer.parseInt(input[2]);
		int len = w*w+h*h;
		
		for(int i=0 ; i<n ; i++) {
			int l = Integer.parseInt(br.readLine());
			if(l*l<=len) bw.write("DA\n");
			else bw.write("NE\n");
		}
		
		bw.flush();
	}
}
