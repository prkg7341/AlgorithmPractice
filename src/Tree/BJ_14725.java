package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_14725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Node root = new Node("");

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());

			Node now = root;

			for (int j = 0; j < num; j++) {
				String temp = st.nextToken();
				if (!now.children.containsKey(temp))
					now.children.put(temp, new Node(temp));
				now = now.children.get(temp);
			}
		}

		for (String name : root.children.keySet()) {
			print(root.children.get(name), 0);
		}
	}

	private static void print(Node node, int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++)
			sb.append("--");
		sb.append(node.name);
		System.out.println(sb);
		for (String name : node.children.keySet()) {
			print(node.children.get(name), depth + 1);
		}
	}

	static class Node implements Comparable<Node> {
		String name;
		TreeMap<String, Node> children = new TreeMap<>();

		Node(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Node o) {
			return this.name.compareTo(o.name);
		}
	}
}