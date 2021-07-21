package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10103 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int chang = 100;
		int sang = 100;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			int c = Integer.parseInt(input[0]);
			int s = Integer.parseInt(input[1]);
			if(c>s) sang -= c;
			if(c<s) chang -= s;
		}

		bw.write(String.valueOf(chang));
		bw.write("\n");
		bw.write(String.valueOf(sang));
		
		bw.flush();
	}
}
