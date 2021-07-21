package Line2021;

import java.util.PriorityQueue;

public class L4 {

	static String global_word;

	public String[] solution(String[] data, String word) {
		String[] answer;

		global_word = word;

		Node[] tree = new Node[data.length+1];
		boolean[] notleaf = new boolean[tree.length];

		for(int i=0 ; i<data.length ; i++) {
			String[] input = data[i].split(" ");

			int id = Integer.parseInt(input[0]);
			String name = input[1];
			int parent = Integer.parseInt(input[2]);

			notleaf[parent] = true;
			Node node = new Node(id, name, parent);

			tree[id] = node;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();

		tree[0] = new Node(0, " ", -1);

		for(Node node : tree) {
			if(!notleaf[node.id] && node.name.contains(word)) {
				pq.add(node);
			}
		}

		answer = new String[pq.size()];

		if(pq.isEmpty()) {
			String ret = "Your search for ("+word+") didn't return any results";
			return new String[] {ret};
		}

		for(int i=0 ; i<answer.length ; i++) {
			Node node = pq.poll();
			StringBuilder sb = new StringBuilder(node.name);
			int parent_id = node.parent;
			while(parent_id!=0) {
				sb.insert(0, "/");
				sb.insert(0, tree[parent_id].name);
				parent_id = tree[parent_id].parent;
			}     
			answer[i] = sb.toString();
		}

		return answer;
	}

	static class Node implements Comparable<Node>{
		int id;
		String name;
		int parent;
		Node(int id, String name, int parent){
			this.id = id;
			this.name = name;
			this.parent = parent;
		}
		@Override
		public int compareTo(Node o) {
			if(this.name.equals(global_word)) return -1;
			else if(o.name.equals(global_word)) return 1;			
			else {
				int count1 = 0;
				int count2 = 0;

				for(int i=0 ; i<this.name.length()-global_word.length() ; i++) {
					if(this.name.substring(i, i+global_word.length()).contains(global_word)) {
						count1++;
						i += global_word.length();
					}
				}
				for(int i=0 ; i<o.name.length()-global_word.length() ; i++) {
					if(o.name.substring(i, i+global_word.length()).contains(global_word)) {
						count2++;
						i += global_word.length();
					}
				}			

				if(count1==count2) {
					if(this.name.indexOf(global_word)==o.name.indexOf(global_word)) {
						return this.id-o.id;
					}
					else {
						return this.name.indexOf(global_word)-o.name.indexOf(global_word);
					}
				}
				else return count2-count1;
			}
		}
	}
}
