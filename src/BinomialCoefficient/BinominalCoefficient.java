package BinomialCoefficient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinominalCoefficient {

	private static int fac(int n){

		int result=1;

		for(int i=1 ; i<=n ; i++){
			result *= i;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String temp = br.readLine();
		int n,k,result;
		n = Integer.parseInt(temp.split(" ")[0]);
		k = Integer.parseInt(temp.split(" ")[1]);
		if(k==0 || k==n){
			result = 1;
		}
		else{
			result = fac(n)/(fac(k)*fac(n-k));
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
