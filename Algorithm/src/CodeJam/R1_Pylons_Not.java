package CodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R1_Pylons_Not {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tt = Integer.parseInt(br.readLine());

		for(int t=1 ; t<=tt ; t++){			
			sb.append("Case #").append(t).append(": ");
			
			String[] input = br.readLine().split(" ");

			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			
			if(r*c<10 || r==1 || c==1) sb.append("IMPOSSIBLE\n");
			
			else{
				if(r*c==16){
					// µû·Î
				}
				else if(c==4 && r>c){
					// swap
				}
				else{
					// µÎÄ­ or ¼¼Ä­¾¿
				}
						
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}