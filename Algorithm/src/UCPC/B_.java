package UCPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for(int i=0 ; i<n ; i++){
			pq.add(Long.parseLong(input[i]));
		}

		for(int i=0 ; i<num ; i++){
			long temp = pq.poll();
			long newNum = temp+pq.poll();
			pq.add(newNum);
			pq.add(newNum);
		}

		long result = 0;
		for(long val : pq){
			result += val;
		}

		System.out.print(result);
	}
}
