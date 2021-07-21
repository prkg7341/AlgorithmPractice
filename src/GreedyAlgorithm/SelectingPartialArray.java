package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectingPartialArray {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}
		long result = rec(ar,0,ar.length-1);
		System.out.print(result);
	}

	static long rec(int[] ar, int left, int right){
		if(right==left){
			return (long)ar[left]*ar[left];
		}
		else{
			int mid = (left+right)/2;
			return Math.max(Math.max(rec(ar,left,mid), rec(ar,mid+1,right)), getMid(ar,left,right));
		}
	}

	static long getMid(int[] ar, int left, int right) {
		int mid = (left+right)/2;
		int mid2 = mid+1;
		long sum = (ar[mid]+ar[mid2]);
		long min = Math.min(ar[mid],ar[mid2]);
		long max = min*sum;

		while(true){
			while(mid2!=right && ar[mid2+1]>=min){
				sum+=ar[++mid2];
			}
			while(mid!=left && ar[mid-1]>=min){
				sum+=ar[--mid];
			}
			max = Math.max(max, min*sum);
			if(mid2!=right && mid!=left){			
				if(ar[mid2+1]>=ar[mid-1]){
					sum += ar[++mid2];
					min = ar[mid2];
				}
				else{
					sum += ar[--mid];
					min = ar[mid];
				}
				max = Math.max(max, min*sum);
			}
			else if(mid2==right && mid!=left){
				sum += ar[--mid];
				min = ar[mid];
				max = Math.max(max, min*sum);
			}
			else if(mid2!=right && mid==left){
				sum += ar[++mid2];
				min = ar[mid2];
				max = Math.max(max, min*sum);
			}
			else{
				break;
			}
		}
		return max;
	}
}