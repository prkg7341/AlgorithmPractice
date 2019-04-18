package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sensor {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int k = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		String[] input = br.readLine().split(" ");

		if(k>=n){
			System.out.print(0);
			return;
		}

		int[][] gap = new int[n-1][2];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(ar);

		for(int i=0 ; i<n-1 ; i++){
			gap[i][0] = i;
			gap[i][1] = ar[i+1]-ar[i];
		}

		Arrays.sort(gap, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int index = 0;

		while(index<k-1){
			pq.add(gap[index++][0]);
		}

		int start=0;
		int result=0;

		while(!pq.isEmpty()){
			index = pq.poll();
			result+=ar[index]-ar[start];
			start = index+1;
		}
		result+=ar[n-1]-ar[start];
		System.out.print(result);
	}
}