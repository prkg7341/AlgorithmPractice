package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixNotation {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();

		Stack<Character> st = new Stack<>();

		for(int i=0 ; i<input.length ; i++){
			char now = input[i];

			if(now>='A' && now<='Z'){
				sb.append(now);
			}

			else if(now=='('){
				st.push(now);
			}

			else if(now==')'){
				while(st.peek()!='('){
					sb.append(st.pop());
				}
				st.pop();
			}

			else if(now=='+' || now=='-'){
				while(!st.isEmpty() && st.peek()!='('){
					sb.append(st.pop());
				}
				st.push(now);				
			}

			else if(now=='*' || now=='/'){
				while(!st.isEmpty() && (st.peek()=='*' || st.peek()=='/') && st.peek()!='('){
					sb.append(st.pop());
				}
				st.push(now);
			}

			else{}
		}
		while(!st.isEmpty()){
			if(st.peek()!='(')
				sb.append(st.pop());
		}
		System.out.print(sb.toString());
	}
}