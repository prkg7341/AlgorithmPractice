package Baemin2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class B3 {
	public int solution(int k, int[] score) {

		HashMap<Integer, ArrayList<Dif>> count = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();

		for(int i=1 ; i<score.length ; i++) {
			int dif = score[i-1] - score[i];

			if(count.containsKey(dif)) {
				ArrayList<Dif> temp = count.get(dif);
				temp.add(new Dif(i-1, i));
				count.put(dif, temp);
			}
			else {
				ArrayList<Dif> temp = new ArrayList<>();
				temp.add(new Dif(i-1, i));
				count.put(dif, temp);
			}
		}

		for(Integer key : count.keySet()) {
			if(count.get(key).size()>=k) {
				for(Dif d : count.get(key)) {
					set.add(d.from);
					set.add(d.to);
				}
			}
		}

		return score.length - set.size();
	}
	
	static class Dif{
		int from;
		int to;
		Dif(int from, int to){
			this.from = from;
			this.to = to;
		}
	}
}
