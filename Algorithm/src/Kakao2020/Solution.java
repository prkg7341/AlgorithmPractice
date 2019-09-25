package Kakao2020;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args){
//		K1 s = new K1();
//		System.out.println(s.solution("aabbaccc"));
//		System.out.println(s.solution("ababcdcdababcdcd"));
//		System.out.println(s.solution("abcabcdede"));
//		System.out.println(s.solution("abcabcabcabcdededededede"));
//		System.out.println(s.solution("xababcdcdababcdcd"));
//		System.out.println(s.solution(""));

//		K2 s = new K2();
//		System.out.println(s.solution("(()())()"));
//		System.out.println(s.solution(")("));
//		System.out.println(s.solution("()))((()"));
		
		K3 s = new K3();
		System.out.println(s.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, 
				new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
		
		
//		K4 s = new K4();
//		System.out.println(Arrays.toString(s.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, 
//				new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
	}
}
