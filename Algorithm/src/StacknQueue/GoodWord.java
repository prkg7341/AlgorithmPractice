package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int count = 0;

		for(int i=0 ; i<n ; i++){
			char[] input = br.readLine().toCharArray();

			Stack<Character> st = new Stack<>();

			for(int j=0 ; j<input.length ; j++){
				char now = input[j];

				if(st.isEmpty()) st.push(now);
				else if(st.peek()!=now) st.push(now);
				else st.pop();
			}
			if(st.size()==0) count++;
		}

		System.out.print(count);
	}
}
