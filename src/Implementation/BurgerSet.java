package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BurgerSet {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum=0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0 ; i<3 ; i++){
			min = Math.min(min, Integer.parseInt(br.readLine()));
		}
		sum += min;
		
		min = Integer.MAX_VALUE;
		
		for(int i=0 ; i<2 ; i++){
			min = Math.min(min, Integer.parseInt(br.readLine()));
		}
		sum += min-50;
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();	
	}
}
