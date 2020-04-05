package LinePlus;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class LP4 {

	public String[][] solution(String[][] snapshots, String[][] transactions) {
		TreeMap<String, Integer> map = new TreeMap<>();

		for(int i=0 ; i<snapshots.length ; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		boolean[] done = new boolean[100001];

		for(int i=0 ; i<transactions.length ; i++) {
			int id = Integer.parseInt(transactions[i][0]);
			if(!done[id]) {
				done[id] = true;
				String todo = transactions[i][1];
				String account = transactions[i][2];
				int value = Integer.parseInt(transactions[i][3]);

				if(todo.equals("SAVE")) {
					if(!map.containsKey(account)) {
						map.put(account, value);
					}
					else {
						map.put(account, map.get(account)+value);
					}
				}
				else {
					if(!map.containsKey(account)) {
						map.put(account, -value);
					}
					else {
						map.put(account, map.get(account)-value);
					}
				}
			}
		}

		String[][] returned = new String[map.size()][2];

		Iterator<String> iteratorKey = map.keySet().iterator();

		int index = 0;

		while(iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			returned[index][0] = key;
			returned[index++][1] = String.valueOf(map.get(key));
		}

		Arrays.parallelSort(transactions, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {				
				return o2[0].compareTo(o1[0]);
			}        	
		});

		return returned;
	}
}
