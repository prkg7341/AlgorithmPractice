package Line2021_2;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		L1 l1 = new L1();
		System.out.println(Arrays.toString(l1.solution("line", new String[] {"-s STRING", "-n NUMBER", "-e NULL"}, new String[] {"line -n 100 -s hi -e", "lien -s Bye"})));
		System.out.println(Arrays.toString(l1.solution("line", new String[] {"-s STRING", "-n NUMBER", "-e NULL"}, new String[] {"line -s 123", "line fun"})));
		

		L2 l2 = new L2();
		System.out.println(Arrays.toString(l2.solution("line", new String[] {"-s STRINGS", "-n NUMBERS", "-e NULL"}, new String[] {"line -n 100 102 -s hi -e", "line -n id pwd -n 100"})));
		System.out.println(Arrays.toString(l2.solution("trip", new String[] {"-days NUMBERS", "-dest STRING"}, new String[] {"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"})));
		

		L3 l3 = new L3();
		System.out.println(Arrays.toString(l3.solution("line", new String[] {"-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num"}, new String[] {"line -n 100 -s hi -e", "line -n 100 -e -num 150"})));
		System.out.println(Arrays.toString(l3.solution("bank", new String[] {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"}, new String[] {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"})));
	}
}
