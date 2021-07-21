package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2072 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int i=0 ; i<t ; i++){
			String[] input = br.readLine().split(" ");
			int sum=0;
			for(int j=0 ; j<input.length ; j++){
				int now = Integer.parseInt(input[j]);
				if(now%2==1) sum+=now;
			}
			sb.append("#"+(i+1)+" "+sum+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}