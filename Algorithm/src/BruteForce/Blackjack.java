package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Blackjack {

	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);

		int max = Integer.parseInt(input[1]);

		int[] ar = new int[n];

		input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		rec(ar, max, 0, 0, 0);
		System.out.print(result);
	}

	private static void rec(int[] ar, int max, int sum, int index, int count) {

		if(sum>max || count>3){
			return;
		}
		else if(index==ar.length){
			if(count==3){
				result = Math.max(sum, result);
			}
			else{
				return;
			}
		}
		else if(count==3){
			result = Math.max(sum, result);
			return;
		}
		else{
			rec(ar, max, sum+ar[index], index+1, count+1);
			rec(ar, max, sum, index+1, count);
		}
	}
}