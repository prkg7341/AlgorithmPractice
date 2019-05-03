package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(ar,0,ar.length-1);

		for(int i : ar){
			sb.append(i).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}

	static void mergeSort(int[] ar, int start, int end){
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(ar, start, mid);
			mergeSort(ar, mid+1, end);
			merge(ar,start,end);
		}
	}

	static void merge(int[] ar, int start, int end){
		int[] ar2 = new int[end-start+1];

		int mid = (start+end)/2;
		int mid2 = mid+1;
		int a = start;

		int index = 0;

		while(a<=mid && mid2<=end){
			if(ar[a]<=ar[mid2]){
				ar2[index++] = ar[a++];
			}
			else{
				ar2[index++] = ar[mid2++];
			}
		}

		while(a<=mid){
			ar2[index++] = ar[a++];
		}		
		while(mid2<=end){
			ar2[index++] = ar[mid2++];
		}

		index = 0;

		for(int i=start ; i<=end ; i++){
			ar[i] = ar2[index++];
		}
	}
}