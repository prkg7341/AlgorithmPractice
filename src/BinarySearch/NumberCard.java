package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCard {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		String[] input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(ar);

		int m = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		for(int i=0 ; i<m ; i++){
			int now = Integer.parseInt(input[i]);
			if(biSearch(ar,now,0,n-1))
				sb.append(String.valueOf(1)+" ");
			else
				sb.append(String.valueOf(0)+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static boolean biSearch(int[] ar, int now, int start, int end) {

		if(start>end) return false;

		int mid = (start+end)/2;

		if(ar[mid]==now){
			return true;
		}
		else if(ar[mid]>now){
			return biSearch(ar,now,start,mid-1);
		}
		else{
			return biSearch(ar,now,mid+1,end);
		}
	}
}
