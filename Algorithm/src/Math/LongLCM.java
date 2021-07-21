package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LongLCM {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		long a = Integer.parseInt(input[0]);
		long b = Integer.parseInt(input[1]);
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		while(max%min!=0){
			long temp = min;
			min = max%min;
			max = temp;
		}
		long mc = min;
		long result = a*b/mc;

		bw.write(String.valueOf(result));	
		bw.flush();
		bw.close();
	}
}
