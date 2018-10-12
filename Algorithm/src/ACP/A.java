package ACP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {
	
	static long cal(long count){
		
		long result;
		result = count + (long)(Math.pow(2, count+1)-1)*(count+1); 
		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		long count = 0;
		
		while(cal(++count)<n){
			
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();

	}

}
