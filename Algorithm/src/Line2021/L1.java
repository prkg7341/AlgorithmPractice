package Line2021;

import java.util.HashMap;

public class L1 {
	public String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";

		HashMap<String, String[]> map = new HashMap<>();

		for(int i=0 ; i<table.length ; i++) {
			String[] temp = table[i].split(" ");
			
			map.put(temp[0], new String[] {temp[1], temp[2], temp[3], temp[4], temp[5]});
		}

		int max = 0;

		for(String st : map.keySet()) {
			String[] ar = map.get(st);

			int score = 0;

			for(int i=0 ; i<ar.length ; i++) {
				String now = ar[i];

				for(int j=0 ; j<languages.length ; j++) {
					if(languages[j].contains(now)) score += preference[j]*(5-i);
				}
			}

			if(score>max) {
				max = Math.max(max, score);
				answer = st;
			}
			if(score==max) {
				if(answer.compareTo(st)>0) {
					answer = st;
				}
			}
		}

		return answer;
	}
}
