package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3431 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {

			sb.append("#").append(tt).append(" ");

			String[] input = br.readLine().split(" ");
			int min = Integer.parseInt(input[0]);
			int max = Integer.parseInt(input[1]);
			int did = Integer.parseInt(input[2]);

			if(did>max) {
				sb.append(-1);
			}
			else if(did<min) {
				sb.append(min-did);
			}
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
