package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2056 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i=1 ; i<=n ; i++){
			sb.append("#"+i+" ");
			String[] input = br.readLine().split("");
			switch(Integer.parseInt(input[4])*10+Integer.parseInt(input[5])){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(Integer.parseInt(input[6])*10+Integer.parseInt(input[7])>=1
				&& Integer.parseInt(input[6])*10+Integer.parseInt(input[7])<=31){
					sb.append(input[0]+input[1]+input[2]+input[3]+"/"+input[4]+input[5]+"/"+input[6]+input[7]+"\n");
				}
				else{
					sb.append(-1+"\n");
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(Integer.parseInt(input[6])*10+Integer.parseInt(input[7])>=1
				&& Integer.parseInt(input[6])*10+Integer.parseInt(input[7])<=30){
					sb.append(input[0]+input[1]+input[2]+input[3]+"/"+input[4]+input[5]+"/"+input[6]+input[7]+"\n");
				}
				else{
					sb.append(-1+"\n");
				}
				break;
			case 2:
				if(Integer.parseInt(input[6])*10+Integer.parseInt(input[7])>=1
				&& Integer.parseInt(input[6])*10+Integer.parseInt(input[7])<=28){
					sb.append(input[0]+input[1]+input[2]+input[3]+"/"+input[4]+input[5]+"/"+input[6]+input[7]+"\n");
				}
				else{
					sb.append(-1+"\n");
				}
				break;
			default: sb.append(-1+"\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}