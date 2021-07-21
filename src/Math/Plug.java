package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plug {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int num = 1;
		
		for(int i=0 ; i<n ; i++){
			num += (Integer.parseInt(br.readLine())-1);
		}
		bw.write(String.valueOf(num));
		bw.flush();
		bw.close();
	}
}
