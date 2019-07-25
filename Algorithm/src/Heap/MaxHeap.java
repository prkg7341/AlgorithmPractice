package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0 ; i<n ; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now==0) {
				if(pq.size()==0) {
					sb.append("0\n");
				}
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
			else {
				pq.add(now);
			}
		}
		System.out.print(sb.toString());
	}
}
