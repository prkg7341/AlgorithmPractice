package StacknQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ_9012 {
	public static void main(String[] args) throws IOException {

		Stack<Character> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());	

		for(int i=0 ; i<n ; i++){

			String input = br.readLine();

			if(input.length()%2==1){
				sb.append("NO\n");
				continue;
			}

			stack.removeAllElements();

			for(int j=0 ; j<input.length() ; j++){

				char now = input.charAt(j);
				if(now==40){
					stack.push(now);
				}
				else{
					if(stack.size()!=0){
						if(stack.peek()!=now){
							stack.pop();
						}
					}
					else{
						sb.append("NO\n");
						break;
					}
				}

				if(j==input.length()-1){
					if(stack.size()==0){
						sb.append("YES\n");
					}	
					else{
						sb.append("NO\n");
					}	
				} 
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
