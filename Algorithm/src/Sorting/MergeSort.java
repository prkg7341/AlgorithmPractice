package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {

	public MergeSort() {

	}

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] ar = new int[n];
		
		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}
		
		new MergeSort().mergeSort(ar, 0, ar.length);
		
	}

	private void mergeSort(int[] ar, int left, int right) {
		
		int middle;
		if (left < right) { 
			middle =(left + right)/2; 
			mergeSort(ar, left, middle); 
			mergeSort(ar, middle+1, right); 
			//merge(ar, left, middle, right); 
		}		
	}
/*
	private void merge(int[] ar, int left, int middle, int right) {
		int n1 = left, n2 = middle+1, s = left, ar2[ar.length], i; 
		while (n1 <= mid && n2 <= high) { 
			if (list[n1]<=list[n2]) 
				sorted[s++] = list[n1++]; 
			else 
				sorted[s++] = list[n2++]; 
		} 
		if (n1 £¾ mid) 
			while (n2 <= high) 
				sorted[s++] = list[n2++]; 
		else 
			while (n1 <= mid) 
				sorted[s++] = list[n1++]; 
		for (i = low; i <= high; i++) 
			list[i] = sorted[i];		
	}*/
	
}
