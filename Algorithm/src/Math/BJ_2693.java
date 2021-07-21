package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_2693 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		
		
		for(int tt=0 ; tt<t ; tt++) {
			String[] input = br.readLine().split(" ");
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=0 ; i<10 ; i++) {
				pq.add(Integer.parseInt(input[i]));
			}
			pq.poll();
			pq.poll();
			bw.write(String.valueOf(pq.peek()));
			bw.write("\n");
		}
		
		bw.flush();
	}
}
