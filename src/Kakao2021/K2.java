package Kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class K2 {
	public String[] solution(String[] orders, int[] course) {

		ArrayList<HashMap<String, Integer>>maps = new ArrayList<>(11);

		for(int i=0 ; i<12 ; i++) {
			maps.add(new HashMap<String, Integer>());
		}

		for(int i=0 ; i<orders.length ; i++) {
			String order = orders[i];
			StringBuilder sb = new StringBuilder();
			char[] ar = order.toCharArray();
			Arrays.parallelSort(ar);
			for(char c : ar) sb.append(c);
			btrk(sb.toString(), "", 0, maps);
		}

		PriorityQueue<Map> pq = new PriorityQueue<>();

		for(int i=0 ; i<course.length ; i++) {
			PriorityQueue<Map_> pq_ = new PriorityQueue<>();
			for(String string : maps.get(course[i]).keySet()) {
				pq_.add(new Map_(string, maps.get(course[i]).get(string)));
			}
			if(pq_.isEmpty()) continue;
			Map_ first = pq_.poll();
			if(first.count==1) continue;
			pq.add(new Map(first.string, first.count));
			
			while(!pq_.isEmpty()) {
				Map_ now = pq_.poll();
				if(now.count==first.count) pq.add(new Map(now.string, now.count));
			}
		}

		String[] answer = new String[pq.size()];
		
		for(int i=0 ; i<answer.length ; i++) {
			answer[i] = pq.poll().string;
		}
		
		return answer;
	}

	private void btrk(String order, String string, int index, ArrayList<HashMap<String, Integer>> maps) {

		if(index==order.length()) {
			if(maps.get(string.length()).containsKey(string)) {
				maps.get(string.length()).put(string, maps.get(string.length()).get(string)+1);
				return;
			}
			maps.get(string.length()).put(string, 1);
			return;
		}

		char now = order.charAt(index);
		btrk(order, string, index+1, maps);
		btrk(order, string+now, index+1, maps);
	}

	static class Map implements Comparable<Map>{
		public Map(String string, int count) {
			this.string = string;
			this.count = count;
		}
		String string;
		int count;
		@Override
		public int compareTo(Map o) {
			return this.string.compareTo(o.string);
		}
	}

	static class Map_ implements Comparable<Map_>{
		public Map_(String string, int count) {
			this.string = string;
			this.count = count;
		}
		String string;
		int count;
		@Override
		public int compareTo(Map_ o) {
			return -this.count+o.count;
		}
	}
}
