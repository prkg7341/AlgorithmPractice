package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] ar = new int[n];

		for(int i=0 ; i<ar.length ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(ar);

		int m = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		for(int i=0 ; i<m ; i++){
			int now = Integer.parseInt(input[i]);
			System.out.println(biSearch(ar, now, 0, ar.length-1));
		}
	}

	private static int biSearch(int[] ar, int now, int start, int end) {

		int index = (start+end)/2;

		if (start > end) return 0;

		if(ar[index]==now){
			return 1;
		}
		else if(ar[index]>now){
			return biSearch(ar,now,start, index-1);
		}
		else{
			return biSearch(ar,now,index+1, end);
		}
	}
}
