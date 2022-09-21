package kakao2022_prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class K1 {
	public int[] solution(String[] id_list, String[] report, int k) {

		int[] answer = new int[id_list.length];

		HashMap<String, HashSet<String>> map = new HashMap<>();
		HashMap<String, Integer> index_map = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			index_map.put(id_list[i], i);
		}

		for (String temp : report) {
			StringTokenizer st = new StringTokenizer(temp);
			String from = st.nextToken();
			String to = st.nextToken();

			if (!map.containsKey(to)) {
				map.put(to, new HashSet<>());
			}
			map.get(to).add(from);
		}

		for (String id : map.keySet()) {
			if (map.get(id).size() >= k) {
				for (String idd : map.get(id)) {
					answer[index_map.get(idd)]++;
				}
			}
		}
		return answer;
	}
}
