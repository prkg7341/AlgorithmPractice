package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ_2981{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n-1];

		int before = Integer.parseInt(br.readLine());

		for(int i=0 ; i<ar.length ; i++) {
			int now = Integer.parseInt(br.readLine());
			ar[i] = Math.abs(now-before);
			before = now;
		}

		before = ar[0];

		for(int i=1 ; i<ar.length ; i++) {
			before = uclid(ar[i],before);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(before);

		for(int i=2 ; i*i<=before ; i++) {
			if(before%i==0) {
				pq.add(i); 
				if (i*i!=before) pq.add(before/i);
			}
		}

		while(!pq.isEmpty()) bw.write(pq.poll()+" ");

		bw.flush();
	}

	private static int uclid(int a, int b) {

		while(true) {
			if(a<b) {
				int temp = a;
				a = b;
				b = temp;
			}

			if(a%b==0) return b;
			else a %= b;
		}
	}
}