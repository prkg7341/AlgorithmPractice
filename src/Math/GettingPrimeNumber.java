package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GettingPrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		boolean[] notSosu = new boolean[b+1];

		notSosu[0] = true;
		notSosu[1] = true;

		for(int i=2 ; i<=b ; i++){
			if(!notSosu[i]){
				if(i>=a){
					sb.append(i+"\n");
				}
				for(int j=i*2 ; j<=b ; j+=i){
					notSosu[j] = true;
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
