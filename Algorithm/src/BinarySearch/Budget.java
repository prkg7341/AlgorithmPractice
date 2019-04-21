package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Budget {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] ar = new int[n];
		int max = -1;
		int sum = 0;

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
			max = Math.max(max, ar[i]);
			sum+=ar[i];
		}

		int mo = Integer.parseInt(br.readLine());

		if(sum<=mo){
			System.out.print(max);
		}		
		else{
			Arrays.sort(ar);
			for(int i=1 ; i<ar.length ; i++){
				ar[i] += ar[i-1];
			}
			System.out.print(get(ar,0,ar.length-1,mo));
		}
	}

	static int get(int[] ar, int start, int end, int mo){
		int mid = (start+end)/2;
		if(mid==0 || end==0){
			mid = 0;
			int now = ar[mid];
			if(now*ar.length>mo){
				return mo/ar.length;
			}
			else if(now*ar.length<mo){
				return (mo-ar[mid])/(ar.length-mid-1);
			}
			else{
				return now;
			}
		}
		else if(start>=end){
			int now = ar[mid]-ar[mid-1];
			if(now*(ar.length-mid)+ar[mid-1]>mo){
				return (mo-ar[mid-1])/(ar.length-mid);
			}
			else if(now*(ar.length-mid)+ar[mid-1]<mo){
				return (mo-ar[mid])/(ar.length-mid-1);
			}
			else{
				return now;
			}
		}
		else{
			int now = ar[mid]-ar[mid-1];
			if(now*(ar.length-mid)+ar[mid-1]>mo){
				return get(ar, start, mid-1, mo);
			}
			else if(now*(ar.length-mid)+ar[mid-1]<mo){
				return get(ar, mid+1, end, mo);
			}
			else{
				return now;
			}
		}		
	}
}