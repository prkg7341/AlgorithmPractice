package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ_15748 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		//		int length = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		int rf = Integer.parseInt(input[2]);
		int rb = Integer.parseInt(input[3]);

		PriorityQueue<Data> pq = new PriorityQueue<>();

		for(int i=0 ; i<n ; i++){
			input = br.readLine().split(" ");
			int distance = Integer.parseInt(input[0]);
			int taste = Integer.parseInt(input[1]);
			pq.add(new Data(distance, taste));
		}

		int position = 0;
		long result = 0;
		while(!pq.isEmpty()){
			Data now = pq.poll();
			if(now.distance>position){
				result += (long)((long)now.taste*(long)(now.distance-position)*(long)(rf-rb));
				position = now.distance;
			}
		}

		bw.write(String.valueOf(result));

		bw.flush();
	}

	static class Data implements Comparable<Data>{

		int distance;
		int taste;

		Data(int distance, int taste){
			this.distance = distance;
			this.taste = taste;
		}

		@Override
		public int compareTo(Data o) {
			if(this.taste>o.taste) return -1;
			else if(this.taste<o.taste) return 1;
			else{
				if(this.distance>o.distance) return -1;
				else return 1;
			}
		}		
	}
}
