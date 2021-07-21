package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiveNSix {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		String a = input[0];
		String b = input[1];

		int maxA = Integer.parseInt(a);
		int minA = Integer.parseInt(a);
		int maxB = Integer.parseInt(b);
		int minB = Integer.parseInt(b);

		for(int i=0 ; i<a.length() ; i++){
			if(a.charAt(a.length()-i-1)=='5'){
				maxA += Math.pow(10, i);
			}
			if(a.charAt(a.length()-i-1)=='6'){
				minA -= Math.pow(10, i);
			}
			if(b.charAt(a.length()-i-1)=='5'){
				maxB += Math.pow(10, i);
			}
			if(b.charAt(a.length()-i-1)=='6'){
				minB -= Math.pow(10, i);
			}
		}
		System.out.println((minA+minB)+" "+(maxA+maxB));
	}
}
