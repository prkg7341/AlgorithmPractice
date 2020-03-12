package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_565_a {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			long n = Long.parseLong(br.readLine());
			int count = 0;
			while(n%2==0){
				n /= 2;
				count++;
			}
			while(n%3==0){
				n /= 3;				
				count += 2;
			}
			while(n%5==0){
				n /= 5;
				count += 3;
			}
			if(n==1){
				sb.append(count);
			}
			else{
				sb.append(-1);
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
