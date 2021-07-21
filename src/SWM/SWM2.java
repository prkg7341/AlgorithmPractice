package SWM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SWM2 {
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		int pc = sc.nextInt();
		int n = sc.nextInt();
		int hour = sc.nextInt();

		ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();

		for(int i=0 ; i<pc ; i++) {
			list.add(new HashMap<Integer, Integer>());
			list.get(i).put(hour, hour);
		}

		for(int i=0 ; i<n ; i++) {
			int num = sc.nextInt();
			int h = sc.nextInt();

			for(int j=h ; j<=hour ; j++) {
				if(list.get(num-1).containsKey(j)) {
					list.get(num-1).put(j-h, j-h);
				}
			}	    	
		}

		for(int i=0 ; i<pc ; i++) {
			int min = 123;
			for(Integer key : list.get(i).keySet()) {
				min = Math.min(min, key);
			}
			System.out.println((i+1)+" "+(hour-min)*1000);
		}
	}
}
