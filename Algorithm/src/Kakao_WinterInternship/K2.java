package Kakao_WinterInternship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class K2 {
	public int[] solution(String s) {

		s = s.substring(2, s.length()-2);
		String[] input = s.split("},\\{");

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<input.length ; i++){
			String[] temp = input[i].split(",");
			for(int j=0 ; j<temp.length ; j++){

				int num = Integer.parseInt(temp[j]);

				if(map.containsKey(num)){
					map.replace(num, map.get(num)+1);
				}

				else{
					map.put(num, 1);
				}
			}
		}

		Iterator it = sortByValue(map).iterator();

		int[] answer = new int[map.size()];
		int index= 0;

		while(it.hasNext()) {

			answer[index++] = Integer.parseInt(it.next().toString());
		}

		return answer;
	}
	public static List sortByValue(final Map map) {

		List<String> list = new ArrayList();

		list.addAll(map.keySet());

		Collections.sort(list,new Comparator() {
			public int compare(Object o1,Object o2) {

				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});

		return list;
	}
}
