package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_11816 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		
		if(input.substring(0, 2).contains("0x")) {
			bw.write(String.valueOf(Integer.parseInt(input.substring(2), 16)));
		}
		else if(input.charAt(0)=='0') {
			bw.write(String.valueOf(Integer.parseInt(input, 8)));		
		}
		else {
			bw.write(input);
		}
		
		bw.flush();
	}
}
