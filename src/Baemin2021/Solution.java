package Baemin2021;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
//		B1 s = new B1();
//		System.out.println(Arrays.toString(s.solution(10)));
//		System.out.println(Arrays.toString(s.solution(14)));
		
//		B2 s = new B2();
//		System.out.println(s.solution(3, new String[] {"01/01 23:20:25 30", "01/01 23:25:50 26", "01/01 23:31:00 05", "01/01 23:33:17 24", "01/01 23:50:25 13", "01/01 23:55:45 20", "01/01 23:59:39 03", "01/02 00:10:00 10"}));
//		System.out.println(s.solution(2, new String[] {"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"}));
		
		B3 s = new B3();
		System.out.println(s.solution(3, new int[] {24,22,20,10,5,3,2,1}));
		System.out.println(s.solution(2, new int[] {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100}));
		
//		B4 s = new B4();
//		System.out.println(s.solution("SEOUL", "DAEGU", "YEOSU", new String[][] {{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}}));
	}
}
