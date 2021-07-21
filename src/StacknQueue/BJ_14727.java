package StacknQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ_14727 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[] ar = new long[n];

		for(int i=0 ; i<n ; i++) {
			ar[i] = Integer.parseInt(br.readLine());					
		}

		Stack<Integer> stack = new Stack<>();

		long max = 0;

		for(int i=0 ; i<n ; i++){
			long now = ar[i];

			if(stack.isEmpty()) stack.add(i);

			else if(now>ar[stack.peek()]){
				stack.add(i);
			}

			else if(now<ar[stack.peek()]){
				while(!stack.isEmpty() && now<ar[stack.peek()]){
					int index = stack.pop();
					long width;
					if(stack.isEmpty()){
						width = i;
					}
					else{
						width = i-stack.peek()-1;
					}
					max = Math.max(max, width*(long)ar[index]);				
				}
				stack.add(i);
			}
		}

		while(!stack.isEmpty()){
			int index = stack.pop();
			long width;
			if(stack.isEmpty()){
				width = n;
			}
			else{
				width = n-stack.peek()-1;
			}
			max = Math.max(max, width*(long)ar[index]);	
		}

		bw.write(Long.toString(max));

		bw.flush();
	}
}
