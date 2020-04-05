package LinePlus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class LP5 {
	public String[] solution(String[][] dataSource, String[] tags) {
		HashMap<String, ArrayList<String>> tag = new HashMap<>();

		TreeMap<String, Integer> docs = new TreeMap<>();

		for(int i=0 ; i<dataSource.length ; i++) {
			String doc = dataSource[i][0];
			for(int j=1 ; j<dataSource[i].length ; j++) {
				String ta = dataSource[i][j];
				if(!tag.containsKey(ta)) tag.put(ta, new ArrayList<String>());
				tag.get(ta).add(doc);
			}
		}

		for(int i=0 ; i<tags.length ; i++) {
			String ta = tags[i];
			for(String doc : tag.get(ta)) {
				if(!docs.containsKey(doc)) docs.put(doc, 1);
				else docs.put(doc, docs.get(doc)+1);
			}
		}

		Iterator<String> iteratorKey = docs.keySet().iterator();
		
		String[][] temp = new String[docs.size()][2];

		int index = 0;

		while(iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			temp[index][0] = key;
			temp[index++][1] = String.valueOf(docs.get(key));
		}
		
		Arrays.parallelSort(temp, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
			}			
		});
		
		String[] returned = new String[temp.length];
		
		for(int i=0 ; i<returned.length ; i++) {
			returned[i] = temp[i][0];
		}

		return returned;
	}
}
