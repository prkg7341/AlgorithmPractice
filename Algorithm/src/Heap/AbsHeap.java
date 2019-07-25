package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsHeap {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Num> pq = new PriorityQueue<>();

		for(int i=0 ; i<n ; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now==0) {
				if(pq.size()==0) {
					sb.append("0\n");
				}
				else {
					Num num = pq.poll();
					int val = num.minus? -num.value : num.value;
					sb.append(val).append("\n");
				}
			}
			else {
				Num new_num = now<0? new Num(-now, true) : new Num(now, false);
				pq.add(new_num);
			}
		}
		System.out.print(sb.toString());
	}

	static class Num implements Comparable<Num>{
		int value;
		boolean minus;
		Num(int value, boolean minus){
			this.value = value;
			this.minus = minus;
		}
		@Override
		public int compareTo(Num o) {
			int result = this.value - o.value;
			if(result==0) {
				if(this.minus) return -1;
				else {
					if(o.minus) return 1;
					else return -1;
				}
			}
			else {
				return result;
			}
		}
	}
}
