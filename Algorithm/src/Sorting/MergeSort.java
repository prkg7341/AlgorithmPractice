package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(ar,0,ar.length-1);

		for(int i=0 ; i<ar.length ; i++){
			sb.append(ar[i]+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void mergeSort(int[] ar, int left, int right) {

		int mid = (left+right)/2;

		if(left!=right){
			mergeSort(ar, left, mid);
			mergeSort(ar, mid+1, right);
			merge(ar, left, right);
		}

	}

	private static void merge(int[] ar, int left, int right) {

		int mid = (left+right)/2;		
		int[] ar2 = new int[ar.length];
		int l = left;
		int m = mid+1;
		int l2 = l;

		while(l<=mid && m<=right){
			if(ar[l]>=ar[m]){
				ar2[l2++] = ar[m++];
			}
			else{
				ar2[l2++] = ar[l++];
			}
		}
		if(l>mid){
			while(l2<=right){
				ar2[l2++] = ar[m++];
			}
		}
		else{
			while(l<=mid){
				ar2[l2++] = ar[l++]; 
			}
		}		
		for(int i=left ; i<=right ; i++){
			ar[i] = ar2[i];
		}
	}
}
