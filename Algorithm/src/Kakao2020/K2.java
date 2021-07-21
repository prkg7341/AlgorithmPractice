package Kakao2020;

import java.util.Stack;

public class K2 {

	public String solution(String p) {
		String answer = "";

		if(p.length()!=0) {
			int index = 0;
			int check = 0;
			for(int i=0 ; i<p.length() ; i+=2) {
				if(p.charAt(i)=='(') check++;
				else check--;
				if(p.charAt(i+1)=='(') check++;
				else check--;
				if(check==0) {
					index = i+2;
					break;
				}
			}

			String u = p.substring(0, index);
			String v = p.substring(index, p.length());

//			System.out.println(u+" "+v);

			if(isRight(u)) {
				answer = u+solution(v);
			}

			else {
				answer = "("+solution(v)+")"+reversed(u.substring(1, u.length()-1));
			}
		}
		return answer;
	}

	private String reversed(String u) {
		String ret = "";
		for(int i=0 ; i<u.length() ; i++) {
			if(u.charAt(i)=='(') {
				ret += ')';
			}
			else ret += '(';
		}
		return ret;
	}

	private boolean isRight(String u) {
		Stack<Character> stack = new Stack<>();
		for(int i=0 ; i<u.length() ; i++) {
			if(u.charAt(i)=='(') {
				stack.push('(');
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
}
