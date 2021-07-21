package Baemin2021;

import java.util.ArrayList;
import java.util.HashMap;

public class B4 {
	
	static int count = 0;
	
	public int solution(String depar, String hub, String dest, String[][] roads) {	
		
		HashMap<String, ArrayList<String>> vertex = new HashMap<>();
		
		for(int i=0 ; i<roads.length ; i++) {
			String start = roads[i][0];
			String end = roads[i][1];
			if(vertex.containsKey(start)) {
				ArrayList<String> temp = vertex.get(start);
				temp.add(end);
				vertex.put(start, temp);
			}
			else {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(end);
				vertex.put(start, temp);
			}
		}
		
		dfs(depar, hub, dest, vertex, false);
				
		return count;
	}

	private void dfs(String now, String hub, String dest, HashMap<String, ArrayList<String>> vertex, boolean bool) {
		
		if(now.equals(hub)) bool = true;
		
		if(now.equals(dest)) {
			if(bool) count++;
			return;
		}
		
		System.out.println(now);
		
		for(String next : vertex.get(now)) {
			dfs(next, hub, dest, vertex, bool);
		}		
	}
}
