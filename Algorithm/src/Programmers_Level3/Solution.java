package Programmers_Level3;

import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {

		P1_���ø���� s = new P1_���ø����();
		System.out.println(s.solution(3, 3, new String[] {"DBA", "C*A", "CDB"}));
		// ABCD
		System.out.println(s.solution(2, 4, new String[] {"NRYN", "ARYA"}));
		// RYAN
		System.out.println(s.solution(4, 4, new String[] {".ZI.", "M.**", "MZU.", ".IU."}));
		// MUZI
		System.out.println(s.solution(2, 2, new String[] {"AB", "BA"}));
		// IMPOSSIBLE
		
//		P2 s = new P2();
//		System.out.println(s.solution(new int[] {120, 110, 140, 150}, 485));
//		// 127
	}
}
