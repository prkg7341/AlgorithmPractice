package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CalculatingDate {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");

		int e = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[2]);
		
		while(e!=m){
			if(m>e) e+=15;
			if(m<e) m+=19;
		}
		while(e!=s){
			if(e>s){
				s+=28;
			}
			if(e<s){
				e+=285;
				m+=285;
			}
		}
		bw.write(String.valueOf(e));		
		bw.flush();
		bw.close();
	}
}
