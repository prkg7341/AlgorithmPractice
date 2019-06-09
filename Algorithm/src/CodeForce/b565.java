package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b565 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			int n = Integer.parseInt(br.readLine());
			int[] ar = new int[3];
			String[] input = br.readLine().split(" ");
			for(int i=0 ; i<n ; i++){
				int now = Integer.parseInt(input[i]);
				if(now%3==0){
					ar[0]++;
				}
				else if(now%3==1){
					ar[1]++;
				}
				else{
					ar[2]++;
				}
			}
			int result = 0;
			result += ar[0];
			int min = Math.min(ar[1], ar[2]);
			result += min;
			ar[1] -= min;
			ar[2] -= min;
			result += ar[1]/3;
			result += ar[2]/3;
			sb.append(result).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
