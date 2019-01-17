package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS {

	// 문자열 출력에 필요한 정적
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		// 입출력을 위한 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);

		// 그래프에 존재하는 정점들의 리스트 생성
		ArrayList<Node> nodes = new ArrayList<>();

		// 리스트에 정점 생성
		for(int i=0 ; i<n ; i++){
			Node node = new Node(i+1);
			nodes.add(node);
		}

		// 입력을 받아 정점들의 이웃을 추가
		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			nodes.get(start-1).neightbor.add(end);
			nodes.get(end-1).neightbor.add(start);
		}

		// 노드의 이웃 리스트 정렬 - 문제 요구사항 (방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문)
		for(Node node : nodes){
			sort(node);
		}		

		// 탐색을 시작할 정점
		Node first = nodes.get(v-1);

		// dfs 탐색결과 저장
		dfs(first, nodes);
		sb.replace(sb.length()-1, sb.length(), "\n");

		// bfs 탐색결과 저장
		bfs(first, nodes);
		sb.deleteCharAt(sb.length()-1);

		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// 리스트 정렬을 위해 임시로 배열로 변환 후 정렬
	private static void sort(Node node) {
		int[] ar = new int[node.neightbor.size()];

		for(int i=0 ; i<ar.length ; i++){
			ar[i] = node.neightbor.get(i);
		}
		Arrays.sort(ar);

		for(int i=0 ; i<ar.length ; i++){
			node.neightbor.set(i, ar[i]);
		}
	}

	private static void dfs(Node node, ArrayList<Node> nodes) {
		// 정점을 방문한 적이 있으면
		if(node.checked){
			return;
		}
		// 정점을 방문한 적이 없으면
		else{
			// 방문여부 체크
			node.checked = true;
			// 출력
			sb.append(node.value+" ");

			// 이웃한 정점에 스택 대신 재귀를 이용하여 탐색
			for(int i : node.neightbor){
				// 체크가 안돼있으면
				if(!nodes.get(i-1).checked){
					// 해당 정점에 대해 탐색
					dfs(nodes.get(i-1), nodes);
				}
			}
		}
	}

	private static void bfs(Node node, ArrayList<Node> nodes) {
		// bfs 탐색을 위한 큐 생성
		Queue<Integer> queue = new LinkedList<>();

		// 큐에 정점 추가
		queue.add(node.value);
		// 방문여부 체크 (이미 dfs에서 체크되었으므로, true와 false를 반대로 생각한다)
		node.checked = false;

		// 큐가 비어있지 않은 동안
		while(!queue.isEmpty()){
			// 큐의 head를 꺼내어 변수에 저장
			int temp = queue.poll();
			// 출력
			sb.append(temp+" ");
			// 이웃한 정점에 큐를 이용하여 탐색
			for(int i : nodes.get(temp-1).neightbor){
				// 체크가 안돼있으면 (역시 반대로 생각)
				if(nodes.get(i-1).checked){
					// 방문여부 체크 (역시 반대로 생각)
					nodes.get(i-1).checked = false;
					// 큐에 추가
					queue.add(i);
				}
			}
		}		
	}

	// 정점 클래스
	static class Node{
		int value; // 값
		boolean checked; // 방문여부
		LinkedList<Integer> neightbor; // 이웃한 정점의 리스트

		Node(int value){
			this.value = value; // 입력받은 값으로 정점 생성
			checked = false; // default를 false로 생성
			neightbor = new LinkedList<>(); // 리스트 초기화
		}
	}
}
