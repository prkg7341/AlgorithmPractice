package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KMP {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		String[] ar = input.split("-");
		
		for(int i=0 ; i<ar.length ; i++){
			sb.append(ar[i].split("")[0]);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
