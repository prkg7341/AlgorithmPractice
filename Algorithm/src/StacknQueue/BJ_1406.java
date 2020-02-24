package StacknQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ_1406 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String st = br.readLine();

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for(char c : st.toCharArray()) left.push(c);

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			String command = input[0];
			switch(command){
			case "L":
				if(left.size()!=0){
					right.push(left.pop());
				}
				break;
			case "D":
				if(right.size()!=0){
					left.push(right.pop());
				}
				break;
			case "B":
				if(left.size()!=0){
					left.pop();
				}
				break;
			case "P":
				char now = input[1].charAt(0);
				left.push(now);
				break;
			}
		}

		while(!left.isEmpty()) right.push(left.pop());

		while(!right.isEmpty()) bw.write(Character.valueOf(right.pop()));

		bw.flush();
	}
}
