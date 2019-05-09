package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuitarLesson {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int len = Integer.parseInt(input[0]);
		int bluelay = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int[] ar = new int[len];

		int sum = 0;

		for(int i=0 ; i<len ; i++){
			ar[i] = Integer.parseInt(input[i]);
			sum += ar[i];
		}

		int ave = sum/bluelay;

		if(sum%bluelay!=0) ave++;

		biSearch(ave, sum, ar, bluelay);

		System.out.print(min);
	}

	private static void biSearch(int i, int j, int[] ar, int bluelay){

		if(i>j) return;

		int mid = (i+j)/2;

		boolean test = test(mid, ar, bluelay);

		if(test){
			min = Math.min(min, mid);
			biSearch(i, mid-1, ar, bluelay);
		}
		else{
			biSearch(mid+1, j, ar, bluelay);			
		}
	}

	private static boolean test(int max, int[] ar, int bluelay) {

		int count=0;

		for(int i=0 ; i<ar.length ; i++){
			int sum = 0;
			while(i<ar.length && sum+ar[i]<=max){
				if(ar[i]>max) return false;
				sum+=ar[i++];
			}
			i--;
			if(++count>bluelay) return false;
		}
		return true;
	}
}