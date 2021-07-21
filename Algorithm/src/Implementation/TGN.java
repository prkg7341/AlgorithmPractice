package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TGN {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<n ; i++){
			st = new StringTokenizer(br.readLine());
			int r, e, c;
			r = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int ad = e-c;
			if(r==ad){
				sb.append("does not matter\n");
			}
			else if(r>ad){
				sb.append("do not advertise\n");
			}
			else{
				sb.append("advertise\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();	
	}
}
