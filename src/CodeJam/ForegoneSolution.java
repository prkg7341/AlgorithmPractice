package CodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForegoneSolution {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){

			int temp=0;

			int n = Integer.parseInt(br.readLine());

			char[] ar = br.readLine().toCharArray();

			int len = ar.length;

			for(int i=0 ; i<len ; i++){
				if(ar[i]=='4'){
					int minus = (int) Math.pow(10, len-i-1);
					n -= minus;
					temp += (int) minus;
				}
			}
			sb.append("Case #").append(tt).append(": ").append(n).append(" ").append(temp).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}