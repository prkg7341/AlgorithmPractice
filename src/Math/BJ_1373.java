package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1373 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		int temp = input.length()%3;

		String first = input.substring(0, temp);
		input = input.substring(temp);

		if(first.length()!=0)
		bw.write(Integer.toOctalString(Integer.parseInt(first, 2)));

		for(int i=0 ; i<input.length()/3 ; i++) {
			bw.write(Integer.toOctalString(Integer.parseInt(input.substring(i*3, (i+1)*3), 2)));
		}

		bw.flush();
	}
}
