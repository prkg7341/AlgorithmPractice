package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NotSquare {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String st = br.readLine();
		int m,n;
		m = Integer.parseInt(st.split(" ")[0]);
		n = Integer.parseInt(st.split(" ")[1]);
		int count = n-m+1;

		for(int i=m ; i<=n ; i++){
			for(int j=1 ; j<=100 ; j++){
				if(i==(int)Math.pow(j, 2)){
					count--;
				}
			}
		}
		
		sb.append(count);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
