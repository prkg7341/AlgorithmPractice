package BinomialCoefficient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinominalCoefficient2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		int n,k,result;
		n = Integer.parseInt(temp.split(" ")[0]);
		k = Integer.parseInt(temp.split(" ")[1]);
		
		if(k>n/2) k = n-k;
		
		
		

	}

}
