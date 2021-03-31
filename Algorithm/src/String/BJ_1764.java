package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BJ_1764 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		HashSet<String> set = new HashSet<>();

		for(int i=0 ; i<n ; i++) {
			set.add(br.readLine());
		}

		PriorityQueue<String> pq = new PriorityQueue<>();

		for(int i=0 ; i<m ; i++){
			String now = br.readLine();
			if(set.contains(now)){
				pq.add(now);
			}
		}

		bw.write(Integer.toString(pq.size()));
		bw.write("\n");

		while(!pq.isEmpty()){
			bw.write(pq.poll());
			bw.write("\n");
		}

		bw.flush();
	}
}
