package BinomialCoefficient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Factorial_NumberOfZeros {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int result;
		
		if(n<25){
			result = n/5;
		}
		else if(n<125){
			result = n/5 + n/25;
		}		
		else{
			result = n/5 + n/25 + n/125;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
