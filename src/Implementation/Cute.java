package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cute {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int cute = 0;
		
		for(int i=0 ; i<n ; i++){
			if(Integer.parseInt(br.readLine())==1) cute++;
		}
		if(2*cute>n) bw.write("Junhee is cute!");
		else bw.write("Junhee is not cute!");
		bw.flush();
		bw.close();	
	}
}
