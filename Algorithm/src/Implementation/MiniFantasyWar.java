package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MiniFantasyWar {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			int hp = Integer.parseInt(input[0]) + Integer.parseInt(input[4]);
			hp = hp<1? 1 : hp;
			int mp = Integer.parseInt(input[1]) + Integer.parseInt(input[5]);
			mp = mp<1? 1 : mp;
			int at = Integer.parseInt(input[2]) + Integer.parseInt(input[6]);
			at = at<0? 0: at;
			int df = Integer.parseInt(input[3]) + Integer.parseInt(input[7]);
			int result = hp+5*mp+2*at+2*df;
			sb.append(result+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());		
		bw.flush();
		bw.close();	
	}
}
