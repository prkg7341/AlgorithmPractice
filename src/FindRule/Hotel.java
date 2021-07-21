package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hotel {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String st;
		int num = Integer.parseInt(br.readLine());
		int h,w,n;
		while(num--!=0){
			st = br.readLine();
			h = Integer.parseInt(st.split(" ")[0]);
			w = Integer.parseInt(st.split(" ")[1]);
			n = Integer.parseInt(st.split(" ")[2]);

			int d1 = n/h;
			int d2 = n%h;
			if(d2==0) {
				d2=h;
				d1-=1;
			}
			sb.append(d1+1+d2*100+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
