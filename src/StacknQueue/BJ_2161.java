package StacknQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_2161 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> d = new LinkedList<>();

		for(int i=1 ; i<=n ; i++) {
			d.addLast(i);
		}

		while(d.size()>=2) {
			bw.write(d.pollFirst()+" ");
			d.addLast(d.pollFirst());
		}

		bw.write(d.pollFirst()+"");

		bw.flush();
	}
}
