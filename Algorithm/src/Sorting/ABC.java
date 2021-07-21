package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class ABC {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i=0 ; i<3 ; i++){
			pq.add(Integer.parseInt(input[i]));
		}

		int[] ar = new int[3];

		for(int i=0 ; i<3 ; i++){
			ar[i] = pq.poll();
		}

		input = br.readLine().split(" ");

		for(int i=0 ; i<3 ; i++){
			char now = input[0].charAt(i);
			if(now=='A') bw.write(ar[0]+" ");
			if(now=='B') bw.write(ar[1]+" ");
			if(now=='C') bw.write(ar[2]+" ");
		}

		bw.flush();
	}
}
