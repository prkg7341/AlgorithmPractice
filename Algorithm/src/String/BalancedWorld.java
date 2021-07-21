package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalancedWorld {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack <Character> stack = new Stack<>();

		while(true){
			String input = br.readLine();

			if(input.compareTo(".")==0) break;

			else{
				stack.clear();
				for(int i=0 ; i<input.length() ; i++){
					char now = input.charAt(i);
					if(now=='(' || now=='[') stack.add(now);
					else if(now==')'){
						if(stack.isEmpty()){
							bw.write("no");
							bw.write("\n");
							break;
						}
						else if(stack.peek()=='(') stack.pop();
						else {
							bw.write("no");
							bw.write("\n");
							break;
						}
					}
					else if(now==']'){
						if(stack.isEmpty()){
							bw.write("no");
							bw.write("\n");
							break;
						}
						else if(stack.peek()=='[') stack.pop();
						else {
							bw.write("no");
							bw.write("\n");
							break;
						}
					}
					else if(now=='.'){
						if(stack.isEmpty()){
							bw.write("yes");
							bw.write("\n");
							break;
						}
						else{
							bw.write("no");
							bw.write("\n");
							break;
						}
					}
					else{
						continue;
					}
				}
			}
		}

		bw.flush();
	}
}
