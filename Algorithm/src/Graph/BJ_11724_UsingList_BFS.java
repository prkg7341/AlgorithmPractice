package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 더 향상시킬 방법을 찾아봤지만, 잘 모르겠고 시간도 많이 들어 일단 스킵
 */
public class BJ_11724_UsingList_BFS {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		if(m==0){
			System.out.print(n);
			return;
		}

		Node[] nodes = new Node[n];

		for(int i=0 ; i<n ; i++){
			nodes[i] = new Node(i+1);
		}

		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");

			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			nodes[a-1].neighbor.add(b);
			nodes[b-1].neighbor.add(a);
		}

		int count = bfs(nodes);

		System.out.print(count);
	}

	private static int bfs(Node[] nodes) {

		int result = 0;

		for(int i=0 ; i<nodes.length ; i++){
			Node now = nodes[i];
			if(!now.checked){
				result++;
				Queue<Integer> q = new LinkedList<>();
				now.checked = true;
				q.add(now.value);
				while(!q.isEmpty()){
					Node todo = nodes[q.poll()-1];
					for(int j=0 ; j<todo.neighbor.size() ; j++){
						Node node = nodes[todo.neighbor.get(j)-1];
						if(!node.checked){
							node.checked = true;
							q.add(node.value);
						}
					}
				}
			}
		}
		return result;
	}

	static class Node{
		int value;
		ArrayList<Integer> neighbor;
		boolean checked;
		Node(int value){
			this.value = value;
			neighbor = new ArrayList<>();
		}
	}
}