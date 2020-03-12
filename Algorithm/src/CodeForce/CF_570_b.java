package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_570_b {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);

			input = br.readLine().split(" ");
			int min = 123456789;
			int max = 0;
			for(int i=0 ; i<n ; i++){
				int now = Integer.parseInt(input[i]);

				min = Math.min(min, now);
				max = Math.max(max, now);
			}
			if(max-min>2*k){
				sb.append(-1).append("\n");
			}
			else{
				sb.append(min+k).append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
