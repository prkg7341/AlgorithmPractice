package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bee {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int i=0;

		while(true){			
			if((3*Math.pow(i, 2)+3*i+1)>=n && (3*Math.pow(i, 2)-3*i+1)<=n){
				bw.write(i+1+"");
				break;
			}
			i++;			
		}
		bw.flush();
		bw.close();

	}

}
