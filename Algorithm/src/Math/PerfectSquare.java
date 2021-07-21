package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PerfectSquare {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int m,n;
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int sum = 0;

		for(int i=m ; i<=n ; i++){
			for(int j=1 ; j<=100 ; j++){
				if(i==(int)Math.pow(j, 2)){
					if(min>i) min = i;
					sum += i;
				}
			}
		}
		
		sb.append(sum);
		sb.append("\n"+min);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
