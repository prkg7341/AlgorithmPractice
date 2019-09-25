package Naver;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args){
//		
//		N1 s1 = new N1();
//		System.out.println(s1.solution(new String[]{"d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"}));
//		System.out.println(s1.solution(new String[]{"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"}));
		
//		N2 s2 = new N2();
//		System.out.println(s2.solution(new String[] {"######",">#*###","####*#","#<#>>#",">#*#*<","######"}));
//		
		N3 s3 = new N3();
		System.out.println(Arrays.toString(s3.solution(new int[][]{{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}})));
		System.out.println(Arrays.toString(s3.solution(new int[][]{{1, 0, 3},{2, 1, 3},{3, 3, 2},{4, 9, 1},{5, 10, 2}})));
		System.out.println(Arrays.toString(s3.solution(new int[][]{{1, 2, 10},{2, 5, 8},{3, 6, 9},{4, 20, 6},{5, 25, 5}})));
	}
}
