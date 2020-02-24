package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ_17509 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;
		int nums = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i=11 ; i>0 ; i--){
			String[] input = br.readLine().split(" ");
			int time = Integer.parseInt(input[0]);
			int num = Integer.parseInt(input[1]);
			
			pq.add(time);
			nums += num;
		}
		
		result += nums*20;

		for(int i=11 ; i>0 ; i--){
			result += pq.poll()*i;
		}

		bw.write(String.valueOf(result));

		bw.flush();
	}
}
