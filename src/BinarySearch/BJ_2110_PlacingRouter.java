package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2110_PlacingRouter {

	static long max = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int house = Integer.parseInt(input[0]);
		int share = Integer.parseInt(input[1]);

		int[] ar = new int[house];

		for(int i=0 ; i<house ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(ar);

		biSearch(1, ar[house-1]-ar[0], ar, share);

		System.out.print(max);
	}

	private static void biSearch(int start, int end, int[] ar, int share){

		if(start>end) return;

		int mid = (start+end)/2;

		boolean test = test(mid, ar, share);

		if(test){
			max = Math.max(max, mid);
			biSearch(mid+1, end, ar, share);
		}
		else{
			biSearch(start, mid-1, ar, share);
		}
	}

	private static boolean test(int mid, int[] ar, int share) {

		int count=0;

		for(int i=0 ; i<ar.length ; i++){
			int now = ar[i];
			while(i+1<ar.length && ar[i+1]-now<mid)
				i++;
			if(++count>=share) return true;
		}
		return false;
	}
}