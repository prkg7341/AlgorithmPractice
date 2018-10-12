package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int a,b;
		
		int[] ar = new int[41];
		ar[0] = 0;
		ar[1] = 1;
		for(int i=2 ; i<=40 ; i++){
			ar[i] = ar[i-2] + ar[i-1];
		}
		
		for(int i=0 ; i<n ; i++){
			int t = Integer.parseInt(br.readLine());
			if(t == 0){
				a=1; b=ar[0];
			}
			else {
				a=ar[t-1]; b=ar[t];
			}
			sb.append(a+" "+b+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
