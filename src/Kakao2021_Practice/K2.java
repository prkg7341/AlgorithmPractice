package Kakao2021_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class K2 {
	public static void main(String[] args) {
		K2 k2 = new K2();
		k2.solution(null, null);
	}

	public String[] solution(String[] orders, int[] course) {

		ArrayList<HashMap<String, Integer>> list = new ArrayList<>();

		for (int i = 0; i <= 11; i++) {
			list.add(new HashMap<>());
		}

		for (int i = 0; i < orders.length; i++) {
			char[] now = orders[i].toCharArray();
			Arrays.sort(now);
			for (int k = 0; k < course.length; k++) {
				HashMap<String, Integer> map = list.get(course[k]);
				c(map, now, new StringBuilder(), course[k], 0);
			}
		}

		PriorityQueue<String> pQueue = new PriorityQueue<>();

		for (HashMap<String, Integer> map : list) {
			if (!map.isEmpty()) {
				LinkedList<String> temp_list = new LinkedList<>();
				int max = 0;
				for (String key : map.keySet()) {
					if (map.get(key) > 1)
						if (map.get(key) > max) {
							temp_list.clear();
							temp_list.add(key);
							max = map.get(key);
						} else if (map.get(key) == max) {
							temp_list.add(key);
						}
				}
				pQueue.addAll(temp_list);
			}
		}

		String[] answer = new String[pQueue.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = pQueue.poll();
		}

		return answer;
	}

	private void c(HashMap<String, Integer> map, char[] now, StringBuilder stringBuilder, int size, int index) {
		if (stringBuilder.length() == size) {
			String temp_key = stringBuilder.toString();
			System.out.println(temp_key);
			if (map.containsKey(temp_key)) {
				map.put(temp_key, map.get(temp_key) + 1);
			} else {
				map.put(temp_key, 1);
			}
			return;
		}

		if (index == now.length)
			return;

		c(map, now, stringBuilder, size, index + 1);
		c(map, now, stringBuilder.append(now[index]), size, index + 1);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
	}
}
