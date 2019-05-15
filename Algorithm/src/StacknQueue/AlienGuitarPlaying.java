package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AlienGuitarPlaying {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int p = Integer.parseInt(input[1]);

		Stack<Integer>[] stack = new Stack[6];

		for(int i=0 ; i<6 ; i++){
			stack[i] = new Stack<Integer>();
		}

		aa:
			for(int i=0 ; i<n ; i++){
				input = br.readLine().split(" ");
				int um = Integer.parseInt(input[0]);
				int pr = Integer.parseInt(input[1]);

				Stack<Integer> now = stack[um-1];

				if(now.isEmpty()) {
					now.push(pr);
					count++;
				}
				else{
					while(!now.isEmpty()){
						int top = now.peek();
						if(top==pr) continue aa;
						else if(top<pr) {
							now.push(pr);
							count++;
							continue aa;
						}
						else{
							now.pop();
							count++;
						}
					}
					now.push(pr);
					count++;
				}
			}
		System.out.print(count);
	}
}
