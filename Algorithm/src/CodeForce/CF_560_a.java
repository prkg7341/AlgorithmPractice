package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CF_560_a {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(n);

		String[] input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			pq.add(Integer.parseInt(input[i]));
		}

		int index = 1;
		int count = 0;

		while(!pq.isEmpty()){
			if(pq.poll()>=index) {
				index++;
				count++;
			}
		}
		System.out.print(count);
	}
}