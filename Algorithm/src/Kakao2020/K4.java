package Kakao2020;

import java.util.HashMap;

public class K4 {
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		Node[] roots = new Node[10001];
		Node[] roots_ = new Node[10001];

		for(int i=1 ; i<roots.length ; i++) {
			roots[i] = new Node();
			roots_[i] = new Node();
		}

		for(int i=0 ; i<words.length ; i++){
			String now = words[i];
			insert(roots[now.length()], now, 0);
			now = new StringBuilder(now).reverse().toString();
			insert(roots_[now.length()], now, 0);
		}

		for(int i=0 ; i<queries.length ; i++) {
			String now = queries[i];
			if(now.charAt(0)=='?') {
				if(now.charAt(now.length()-1)=='?') {
					for(Character c : roots_[now.length()].children.keySet()) {
						answer[i] += roots_[now.length()].children.get(c).count;
					}
					continue;
				}
				now = new StringBuilder(now).reverse().toString();
				answer[i] = dfs(roots_[now.length()], now, 0);
			}
			else {
				answer[i] = dfs(roots[now.length()], now, 0);
			}
		}

		return answer;
	}

	private int dfs(Node node, String word, int index) {
		if(word.charAt(index)=='?') return node.count;
		if(!node.children.containsKey(word.charAt(index))) {
			return 0;
		}
		return dfs(node.children.get(word.charAt(index)), word, index+1);
	}

	private void insert(Node node, String word, int index) {
		if(index==word.length()) return;
		char now = word.charAt(index);
		if(!node.children.containsKey(now)) {
			node.children.put(now, new Node());
		}
		else node.children.get(now).count++;
		insert(node.children.get(now), word, index+1);
	}

	static class Node{
		HashMap<Character, Node> children = new HashMap<>();
		int count = 1;
	}
}
