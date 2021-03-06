package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();

		for(int i=1 ; i<=n ; i++){
			queue.add(i);
		}
		while(queue.size()>=2){
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.print(queue.poll());
	}
}
