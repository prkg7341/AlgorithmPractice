package Heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ_1715 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i=0 ; i<n ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int sum = 0;

		while(pq.size()>1) {
			int now = pq.poll()+pq.poll();
			sum += now;
			pq.add(now);
		}

		bw.write(String.valueOf(sum));

		bw.flush();
	}
}
