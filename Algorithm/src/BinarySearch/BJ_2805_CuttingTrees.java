package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2805_CuttingTrees {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[] trees = new int[n];

		int max = -1;

		input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			trees[i] = Integer.parseInt(input[i]);
			max = Math.max(max, trees[i]);
		}

		System.out.print(getH(trees, 0, max, m));
	}
	static int getH(int[] trees, int start, int end, int value){
		//		if(start>end){
		//			System.out.println("000");
		//			return end;
		//		}
		int mid = (start+end)/2;
		long result = 0;
		for(int i=0 ; i<trees.length ; i++){
			int now = trees[i]-mid;
			if(now>0)
				result+=now;
		}
		if(start<end){
			if(result==value){
				return mid;
			}
			else if(result<value){
				return getH(trees, start, mid-1, value);
			}
			else{
				return getH(trees, mid+1, end, value);			
			}
		}
		else if(start==end){
			if(result==value){
				return mid;
			}
			else if(result<value){
				return mid-1;
			}
			else{
				return mid;
			}
		}
		else{
			if(result==value){
				return mid;
			}
			else if(result<value){
				return mid-1;
			}
			else{
				return mid;			
			}
		}
	}
}