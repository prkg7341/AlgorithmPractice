package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=1 ; i<=10 ; i++) {
			br.readLine();

			char[] ar = br.readLine().toCharArray();

			Stack<Character> stack = new Stack<>();

			boolean fin = false;

			for(char c : ar) {
				if(fin) break;
				switch(c) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack.add(c);
					break;				
				case ')':
					if(!stack.isEmpty() && stack.peek()=='(') {
						stack.pop();
					}
					else {
						System.out.println("#"+i+" "+0);
						fin = true;
					}
					break;
				case ']':
					if(!stack.isEmpty() && stack.peek()=='[') {
						stack.pop();
					}
					else {
						System.out.println("#"+i+" "+0);
						fin = true;
					}
					break;
				case '}':
					if(!stack.isEmpty() && stack.peek()=='{') {
						stack.pop();
					}
					else {
						System.out.println("#"+i+" "+0);
						fin = true;
					}
					break;
				case '>':
					if(!stack.isEmpty() && stack.peek()=='<') {
						stack.pop();
					}
					else {
						System.out.println("#"+i+" "+0);
						fin = true;
					}
					break;
				}
			}
			if(!fin) System.out.println("#"+i+" "+1);
		}
	}	
}
