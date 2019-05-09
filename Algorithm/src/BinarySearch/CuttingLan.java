package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuttingLan {

	static long max = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int have = Integer.parseInt(input[0]);
		int need = Integer.parseInt(input[1]);

		int[] ar = new int[have];

		int big = 0;

		for(int i=0 ; i<have ; i++){
			ar[i] = Integer.parseInt(br.readLine());
			big = Math.max(big, ar[i]);
		}

		biSearch(1, big, ar, need);

		System.out.print(max);
	}

	private static void biSearch(long i, long j, int[] ar, int need){

		if(i>j) return;

		long mid = (i+j)/2;

		boolean test = test(mid, ar, need);

		if(test){
			max = Math.max(max, mid);
			biSearch(mid+1, j, ar, need);
		}
		else{
			biSearch(i, mid-1, ar, need);
		}
	}

	private static boolean test(long mid, int[] ar, int need) {

		int count=0;

		for(int i=0 ; i<ar.length ; i++){
			count += ar[i]/mid;
			if(count>=need){
				return true;
			}
		}
		return false;
	}
}