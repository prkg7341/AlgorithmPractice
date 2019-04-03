package Star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star17 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i=1 ; i<n ; i++){
			for(int j=i+1 ; j<=n ; j++){
				sb.append(" ");
			}
			sb.append("*");
			for(int j=2 ; j<=2*(i-1) ; j++){
				sb.append(" ");
			}
			if(i!=1)
				sb.append("*");
			sb.append("\n");
		}
		for(int i=1 ; i<=2*n-1 ; i++){
			sb.append("*");
		}

		System.out.print(sb.toString());
	}
}