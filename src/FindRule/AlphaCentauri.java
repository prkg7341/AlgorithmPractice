package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AlphaCentauri {

	static int get(int last, int count){
		last -= 2*count;
		
		if(last<=0){
			return 2*count;
		}

		else if((last-1)<=count){
			return 2*count+1;
		}
		else{
			return get(last, count+1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String st;
		int x,y,last, count=1;

		while(n--!=0){
			st = br.readLine();
			x = Integer.parseInt(st.split(" ")[0]);
			y = Integer.parseInt(st.split(" ")[1]);
			last = y-x; //°Å¸®

			if(last<=3){
				sb.append(last+"\n");
			}
			else{
				sb.append(get(last, count)+"\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
