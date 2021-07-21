package SWM;

import java.util.HashMap;
import java.util.Scanner;

public class SWM5 {
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0 ; i<n*n ; i++) {
			int score = sc.nextInt();
			int num = sc.nextInt();
			for(int j=0 ; j<num ; j++) {
				int t = sc.nextInt();
				
				if(map.containsKey(t)) {
					if(map.get(t)<score) map.put(t, score);
				}
				else {
					map.put(t, score);
				}
			}
		}

		int result = 0;
		for(Integer i : map.keySet()) result += map.get(i);
		System.out.println(result);
	}
}
