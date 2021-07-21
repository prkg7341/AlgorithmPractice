package Star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star15 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		if(n==1){
			System.out.println("*");
			return;
		}

		for(int i=0 ; i<n-1 ; i++){
			sb.append(" ");
		}

		sb.append("*\n");

		for(int i=1 ; i<n ; i++){
			for(int j=0 ; j<n-i-1 ; j++){
				sb.append(" ");
			}
			sb.append("*");
			for(int j=0 ; j<2*i-1 ; j++){
				sb.append(" ");
			}
			sb.append("*\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
