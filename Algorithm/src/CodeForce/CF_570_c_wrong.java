package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_570_c_wrong {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			String[] input = br.readLine().split(" ");

			int bat = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			int a = Integer.parseInt(input[2]);
			int b = Integer.parseInt(input[3]);

			bat -= n*b;

			if(bat<=0){
				sb.append(-1).append("\n");
			}
			else{
				int result = 0;
				int minus = a-b;

				result = bat/minus;

				if(result>n) {
					result = n;
				}
				else if(bat%minus==0){
					result--;
				}
				sb.append(result).append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
