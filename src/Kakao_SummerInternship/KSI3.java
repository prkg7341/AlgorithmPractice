package Kakao_SummerInternship;

import java.util.ArrayList;
import java.util.Stack;

public class KSI3 {
	public String solution(int n, int k, String[] cmd) {
		StringBuilder answer = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		ArrayList<Integer> list = new ArrayList<>();

		int now = k;

		for(int i=0 ; i<n ; i++) {
			list.add(i);
		}

		for(int i=0 ; i<cmd.length ; i++) {
			if(cmd[i].contains("U")) {
				now -= (int) (cmd[i].charAt(cmd[i].length()-1)-'0');
			}
			else if(cmd[i].contains("D")) {
				now += (int) (cmd[i].charAt(cmd[i].length()-1)-'0');
			}
			else if(cmd[i].contains("C")) {
				stack.add(list.remove(now));   
				if(now==list.size()) now--;
			}
			else {// Z
				int index = bs(list, stack.peek(), 0, list.size()-1);
				if(index<=now) now ++;
				list.add(index, stack.pop());
			}
		}

		boolean[] ar = new boolean[n];

		//for(boolean boo : ar) boo? answer.append('O') : answer.append("X");

		for(int i : list) {
			ar[i] = true;
		}
		
		for(boolean boo : ar) {
			char next = boo? 'O' : 'X';
			answer.append(next);
		}

		return answer.toString();
	}

	private int bs(ArrayList<Integer> list, int value, int left, int right) {

		int mid = (left+right)/2;

		if(left>right) return left;

		if(list.get(mid)>value){
			return bs(list, value, left, mid-1);
		}
		else if(list.get(mid)<value){
			return bs(list, value, mid+1, right);
		}
		else{
			return -1;
		}
	}
}
