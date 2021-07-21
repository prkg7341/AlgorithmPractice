package Star;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star7 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=n ; i++){
			for(int j=n-i ; j>0 ; j--){
				sb.append(" ");
			}
			for(int j=2*i-1 ; j>0 ; j--){
				sb.append("*");
			}			
			sb.append("\n");
		}
		for(int i=1 ; i<n ; i++){
			for(int j=0 ; j<i ; j++){
				sb.append(" ");
			}
			for(int j=2*(n-i)-1 ; j>0 ; j--){
				sb.append("*");
			}			
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
