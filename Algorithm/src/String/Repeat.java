package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Repeat {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String st;
		int m;
		String str;
		for(int i=0 ; i<n ; i++){
			st = br.readLine();
			m = Integer.parseInt(st.split(" ")[0]);
			str = st.split(" ")[1];
			for(int j=0 ; j<str.length() ; j++){
				for(int k=0 ; k<m ; k++){
					sb.append(str.charAt(j));
				}				
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
