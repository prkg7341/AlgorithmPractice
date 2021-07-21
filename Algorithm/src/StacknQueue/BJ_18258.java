package StacknQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_18258 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> d = new LinkedList<>();

		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			switch(command) {
			case "push":
				int now = Integer.parseInt(input[1]);
				d.addLast(now);
				break;
			case "pop":
				if(d.isEmpty()) bw.write(String.valueOf("-1"));
				else bw.write(String.valueOf(d.removeFirst()));
				bw.write("\n");
				break;
			case "size":
				bw.write(String.valueOf(d.size()));
				bw.write("\n");
				break;
			case "empty":
				if(d.isEmpty()) bw.write(String.valueOf(1));
				else bw.write(String.valueOf(0));
				bw.write("\n");
				break;
			case "front":
				if(d.isEmpty()) bw.write(String.valueOf("-1"));
				else bw.write(String.valueOf(d.peekFirst()));
				bw.write("\n");
				break;
			case "back":
				if(d.isEmpty()) bw.write(String.valueOf("-1"));
				else bw.write(String.valueOf(d.peekLast()));
				bw.write("\n");
				break;
			}
		}

		bw.flush();
	}
}
