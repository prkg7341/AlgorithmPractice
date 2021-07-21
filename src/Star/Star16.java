package Star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star16 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i=1 ; i<=n ; i++){
			for(int j=i+1 ; j<=n ; j++){
				sb.append(" ");
			}
			for(int j=1 ; j<=i ; j++){
				sb.append("* ");
			}
			sb.replace(sb.length()-1,sb.length(),"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}