package Kakao_WinterInternship;

import java.util.Stack;

public class K1 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> st = new Stack<>();

		int[] h = new int[board.length];

		for(int i=0 ; i<board.length ; i++){
			for(int j=0 ; j<board.length ; j++){
				if(board[j][i]!=0) {
					h[i] = j+1;
					break;
				}
			}
		}

		for(int i=0 ; i<moves.length ; i++){
			int where = moves[i]-1;
			if(h[where]!=board.length+1) {
				if(st.isEmpty()) {
					st.add(board[h[where]-1][where]);
				}
				else if(st.peek()==board[h[where]-1][where]){
					st.pop();
					answer += 2;
				}
				else{
					st.add(board[h[where]-1][where]);
				}
				h[where]++;
			}
		}
		return answer;
	}
}
