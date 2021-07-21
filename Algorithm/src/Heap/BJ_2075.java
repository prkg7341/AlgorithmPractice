package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_2075 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder());

		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++) {
				if(i==1 && j==0) {
					PriorityQueue<Integer> pq_temp = new PriorityQueue<>(n);
					pq_temp.addAll(pq);
					pq = pq_temp;
				}
				int now = Integer.parseInt(input[j]);
				if(pq.size()<n) pq.add(now);
				else {
					if(pq.peek()<now) {
						pq.poll();
						pq.add(now);
					}
				}
			}
		}

		System.out.print(pq.peek());
	}
}
