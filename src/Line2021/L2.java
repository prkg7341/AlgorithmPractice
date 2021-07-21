package Line2021;

import java.util.HashMap;
import java.util.PriorityQueue;

public class L2 {
	public int[] solution(String inp_str) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		if(inp_str.length()>15 || inp_str.length()<8) pq.add(1);

		boolean[] inc = new boolean[4];

		int[] table1 = new int[26];
		int[] table2 = new int[26];
		int[] table3 = new int[10];

		HashMap<Character, Integer> map = new HashMap<>();

		map.put('~', 0);
		map.put('!', 0);
		map.put('@', 0);
		map.put('#', 0);
		map.put('$', 0);
		map.put('%', 0);
		map.put('^', 0);
		map.put('&', 0);
		map.put('*', 0);

		HashMap<Character, Integer> map2 = new HashMap<>();
		map2.put('(', 0);
		map2.put(')', 0);
		map2.put('-', 0);
		map2.put('_', 0);
		map2.put('=', 0);
		map2.put('+', 0);

		char before = ' ';
		int ser = 0;

		boolean second = false;
		boolean fourth = false;
		boolean fifth = false;

		for(int i=0 ; i<inp_str.length() ; i++) {
			char now = inp_str.charAt(i);

			if(now==before) {
				ser++;
				if(ser>3 && !fourth) {
					pq.add(4);
					fourth = true;
				}
			}
			else {
				before = now;
				ser = 1;
			}			

			if(now>='A' && now<='Z') {
				inc[0] = true;
				table1[(int)(now-'A')]++;
				if(table1[(int)(now-'A')]>4 && !fifth) {
					fifth = true;
					pq.add(5);
				}
			}
			else if(now>='a' && now<='z') {
				inc[1] = true;
				table2[(int)(now-'a')]++;
				if(table2[(int)(now-'a')]>4){
					fifth = true;
					pq.add(5);
				}
			}
			else if(now>='0' && now<='9') {
				inc[2] = true;
				table3[(int)(now-'0')]++;
				if(table3[(int)(now-'0')]>4) {
					fifth = true;
					pq.add(5);
				}
			}
			else {
				if(map.containsKey(now)) {
					if(map.get(now)>3) {
						fifth = true;
						pq.add(5);
					}
					map.replace(now, map.get(now)+1);
				}
				else {
					if(!second) {
						pq.add(2);
						second = true;
					}			
					if(map2.get(now)>3) {
						fifth = true;
						pq.add(5);
					}
					map2.replace(now, map2.get(now)+1);		
				}
			}
		}

		int count = 0;

		for(int i=0 ; i<inc.length ; i++) {
			if(inc[i]) count++;
		}

		if(count<3) pq.add(3);

		int[] answer;

		if(pq.size()==0) {
			answer = new int[] {0};
		}
		else {
			answer = new int[pq.size()];

			for(int i=0 ; i<answer.length ; i++) {
				answer[i] = pq.poll();
			}
		}

		return answer;
	}
}
