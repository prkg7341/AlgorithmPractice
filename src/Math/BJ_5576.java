package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_5576 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0 ; i<10 ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		for(int i=0 ; i<3 ; i++) {
			sum += pq.poll();
		}
		
		pq.clear();
		
		for(int i=0 ; i<10 ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum2 = 0;
		for(int i=0 ; i<3 ; i++) {
			sum2 += pq.poll();
		}
		
		bw.write(sum+" "+sum2);
		
		bw.flush();
	}
}
