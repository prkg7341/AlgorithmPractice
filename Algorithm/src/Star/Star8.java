package Star;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star8 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<2*n ; j++){
				if(j<=i || j>=2*n-i-1){
					sb.append("*");
				}
				else{
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		for(int i=1 ; i<n ; i++){
			for(int j=n-i ; j>0 ; j--){
				sb.append("*");
			}
			for(int j=2*i ; j>0 ; j--){
				sb.append(" ");
			}			
			for(int j=n-i ; j>0 ; j--){
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
