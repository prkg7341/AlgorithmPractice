package CodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YouCanGoYourOwnWay {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){

			sb.append("Case #").append(tt).append(": ");

			int n = Integer.parseInt(br.readLine());

			char[] input = br.readLine().toCharArray();

			for(int i=0 ; i<input.length ; i++){
				sb.append(input[i]=='S'? 'E' : 'S');
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}