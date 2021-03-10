package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_11656 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		String[] dic = new String[input.length()];

		for(int i=0 ; i<input.length() ; i++) {
			dic[i] = input.substring(i);
		}

		Arrays.sort(dic);

		for(String st : dic) bw.write(st+"\n");

		bw.flush();
	}
}
