package Kakao2020_intern;

import java.util.HashMap;
import java.util.Map.Entry;

public class K3 {
	public int[] solution(String[] gems) {

		HashMap<String, Integer> map = new HashMap<>();

		int from = 0;
		int to = 0;

		int tempF = 0;
		int tempT = 0;

		for(int i=0 ; i<gems.length ; i++) {
			String now = gems[i];

			if(!map.containsKey(now)) {
				map.put(now, i);
				from = tempF;
				to = i;
			}

			else {			
				int temp_min = Integer.MAX_VALUE;

				if(map.get(now)==tempF) {
					map.replace(now, i);
					for (Entry<String, Integer> entry : map.entrySet()) {
						int value = entry.getValue();

						temp_min = Math.min(temp_min, value);					
					}
				}

				if(temp_min!=Integer.MAX_VALUE)
					tempF = temp_min;

				tempT = i;

				if(tempT-tempF<to-from) {
					to = tempT;
					from = tempF;
				}
				map.replace(now, i);
			}
		}

		int[] answer = {from+1, to+1};
		return answer;
	}

	//	static class Gem implements Comparable<Gem>{
	//		String name;
	//		int first;
	//		int last;
	//		Gem(String name, int first, int last){
	//			this.name = name;
	//			this.first = first;
	//			this.last = last;
	//		}
	//		@Override
	//		public int compareTo(Gem o) {
	//			return this.first >= o.first ? 1 : - 1;
	//		}
	//	}
}
