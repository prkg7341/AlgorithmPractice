package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_5596 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int sum = 0;
		for(String st : input) sum += Integer.parseInt(st);
		
		input = br.readLine().split(" ");
		int sum2 = 0;
		for(String st : input) sum2 += Integer.parseInt(st);
		
		bw.write(String.valueOf(Math.max(sum, sum2)));
		
		bw.flush();
	}
}
