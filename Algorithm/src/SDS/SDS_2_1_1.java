package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SDS_2_1_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine().split(" ")[0]);

		for(int tt=1 ; tt<=t ; tt++){
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			
			int[] ar = new int[k+1];

			input = br.readLine().split(" ");

			int color = 1;
			int max = 0;
			int count = 0;
			int zeros = 0;

			for(int i=0 ; i<n ; i++){
				int now = Integer.parseInt(input[i]);

				if(now==0){
					zeros++;
				}
				else if(now==color){
					count++;
					count+=zeros;
					zeros = 0;
				}
				else{
					color = now;
					max = Math.max(max, count+zeros);
					count = zeros+1;
				}
			}
			sb.append("#").append(tt).append(" ").append(max).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
