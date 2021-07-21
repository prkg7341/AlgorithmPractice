package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GCDnLCM {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while(max%min!=0){
			int temp = min;
			min = max%min;
			max = temp;
		}
		int mc = min;
		int result = a*b/mc;

		bw.write(String.valueOf(mc)+"\n"+String.valueOf(result));	
		bw.flush();
		bw.close();
	}
}
