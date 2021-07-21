package LinePlus;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args){
		
//		LP1 s1 = new LP1();
//		System.out.println(s1.solution("Hello, world!"));
//		System.out.println(s1.solution("line [plus]"));
//		System.out.println(s1.solution("if (Count of eggs is 4.) {Buy milk.}"));
//		System.out.println(s1.solution(">_<"));
		
//		LP2 s2 = new LP2();
//		System.out.println(s2.solution("4132315142", new String[] {"3241523133","4121314445","3243523133","4433325251","2412313253"}));
//		System.out.println(s2.solution("53241", new String[] {"53241", "42133", "53241", "14354"}));
//		System.out.println(s2.solution("24551", new String[] {"24553", "24553", "24553", "24553"}));
		
//		LP3 s3 = new LP3();
//		System.out.println(s3.solution("111011110011111011111100011111", 3));
//		System.out.println(s3.solution("001100", 5));
		
//		LP4 s4 = new LP4();
//		System.out.println(Arrays.deepToString(s4.solution(new String[][] {{"ACCOUNT1", "100"},{"ACCOUNT2", "150"}}, new String[][]{{"1", "SAVE", "ACCOUNT2", "100"},{"2", "WITHDRAW", "ACCOUNT1", "50"},{"1", "SAVE", "ACCOUNT2", "100"},{"4", "SAVE", "ACCOUNT3", "500"},{"3", "WITHDRAW", "ACCOUNT2", "30"}})));
				
		
		LP5 s5 = new LP5();
		System.out.println(Arrays.toString(s5.solution(new String[][] {{"doc1", "t1", "t2", "t3"},{"doc2", "t0", "t2", "t3"},{"doc3", "t1", "t6", "t7"},{"doc4", "t1", "t2", "t4"},{"doc5", "t6", "t100", "t8"}}, new String[] {"t1", "t2", "t3"})));
	}
}
