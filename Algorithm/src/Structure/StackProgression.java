package Structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackProgression {
	public static void main(String[] args) throws IOException {
		
		Stack<Integer> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int next = 0;
		
		for(int i=0 ; i<n ; i++){
			int input = Integer.parseInt(br.readLine());
			int top;
			if(stack.size()==0){
				top = 0;
			}
			else{
				top = stack.peek();
			}
			
			if(input>top){
				while(next<input){
					stack.push(++next);
					sb.append("+\n");				
				}
				stack.pop();
				sb.append("-\n");
			}
			else if(input==top){
				stack.pop();
				sb.append("-\n");
			}
			else{
				System.out.println("NO");
				return;
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
