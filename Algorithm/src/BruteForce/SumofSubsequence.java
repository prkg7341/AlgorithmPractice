package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofSubsequence {

	static int count=0;
	static int s;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);

		if(s==0) count--;

		int sum=0;

		input = br.readLine().split(" ");

		int[] ar = new int[n];

		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(input[i]);
			sum+=ar[i];
		}

		check(ar,sum,0,true);

		System.out.print(count);
	}

	static void check(int[] ar, int sum, int index, boolean can){
		if(can && sum==s) count++;
		if(index<ar.length){
			check(ar,sum,index+1,false);
			check(ar,sum-ar[index],index+1,true);
		}
	}
}