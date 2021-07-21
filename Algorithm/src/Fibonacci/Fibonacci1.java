package Fibonacci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[] ar = new long[n];

		for(int i=0 ; i<n ; i++){
			if(i==0 || i==1){
				ar[i] = 1;
			}
			else {
				ar[i] = ar[i-1]+ar[i-2];
				if(i!=29 && (ar[i]%1000000==ar[29])){
					System.out.println(i); break;
				}
			}			
		}
		bw.write(ar[n-1]+"");
		bw.flush();
		bw.close();

	}
}
