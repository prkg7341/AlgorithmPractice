package LinePlus;

import java.util.Stack;

public class LP1 {

	public int solution(String inputString) {
		char[] input = inputString.toCharArray();

		Stack<Character> stack = new Stack<>();

		int count = 0;

		for(int i=0 ; i<input.length ; i++) {
			char now = input[i];
			switch(now) {
			case '(':
			case '{':
			case '[':
			case '<':
				stack.add(now);        		
				break;
			case ')':
				if(stack.isEmpty() || stack.peek()!='(') return -1;
				else {
					stack.pop();
					count++;
				}
				break;
			case '}':
				if(stack.isEmpty() || stack.peek()!='{') return -1;
				else {
					stack.pop();
					count++;
				}
				break;
			case ']':
				if(stack.isEmpty() || stack.peek()!='[') return -1;
				else {
					stack.pop();
					count++;
				}
				break;
			case '>':
				if(stack.isEmpty() || stack.peek()!='<') return -1;
				else {
					stack.pop();
					count++;
				}
				break;
			default: break;
			}
		}
		return count;
	}
}
