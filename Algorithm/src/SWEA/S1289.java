package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1289 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {

			sb.append("#").append(tt).append(" ");

			char[] input = br.readLine().toCharArray();

			int result = 0;

			char before = '0';

			for(int i=0 ; i<input.length ; i++) {
				char now = input[i];

				if(now!=before) {
					before = now;
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
