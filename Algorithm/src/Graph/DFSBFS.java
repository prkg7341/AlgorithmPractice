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

	// ���ڿ� ��¿� �ʿ��� ����
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		// ������� ���� ��ü ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// �Է� �ޱ�
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);

		// �׷����� �����ϴ� �������� ����Ʈ ����
		ArrayList<Node> nodes = new ArrayList<>();

		// ����Ʈ�� ���� ����
		for(int i=0 ; i<n ; i++){
			Node node = new Node(i+1);
			nodes.add(node);
		}

		// �Է��� �޾� �������� �̿��� �߰�
		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			nodes.get(start-1).neightbor.add(end);
			nodes.get(end-1).neightbor.add(start);
		}

		// ����� �̿� ����Ʈ ���� - ���� �䱸���� (�湮�� �� �ִ� ������ ���� ���� ���, ���� ��ȣ�� ���� ���� ���� �湮)
		for(Node node : nodes){
			sort(node);
		}		

		// Ž���� ������ ����
		Node first = nodes.get(v-1);

		// dfs Ž����� ����
		dfs(first, nodes);
		sb.replace(sb.length()-1, sb.length(), "\n");

		// bfs Ž����� ����
		bfs(first, nodes);
		sb.deleteCharAt(sb.length()-1);

		// ���
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// ����Ʈ ������ ���� �ӽ÷� �迭�� ��ȯ �� ����
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
		// ������ �湮�� ���� ������
		if(node.checked){
			return;
		}
		// ������ �湮�� ���� ������
		else{
			// �湮���� üũ
			node.checked = true;
			// ���
			sb.append(node.value+" ");

			// �̿��� ������ ���� ��� ��͸� �̿��Ͽ� Ž��
			for(int i : node.neightbor){
				// üũ�� �ȵ�������
				if(!nodes.get(i-1).checked){
					// �ش� ������ ���� Ž��
					dfs(nodes.get(i-1), nodes);
				}
			}
		}
	}

	private static void bfs(Node node, ArrayList<Node> nodes) {
		// bfs Ž���� ���� ť ����
		Queue<Integer> queue = new LinkedList<>();

		// ť�� ���� �߰�
		queue.add(node.value);
		// �湮���� üũ (�̹� dfs���� üũ�Ǿ����Ƿ�, true�� false�� �ݴ�� �����Ѵ�)
		node.checked = false;

		// ť�� ������� ���� ����
		while(!queue.isEmpty()){
			// ť�� head�� ������ ������ ����
			int temp = queue.poll();
			// ���
			sb.append(temp+" ");
			// �̿��� ������ ť�� �̿��Ͽ� Ž��
			for(int i : nodes.get(temp-1).neightbor){
				// üũ�� �ȵ������� (���� �ݴ�� ����)
				if(nodes.get(i-1).checked){
					// �湮���� üũ (���� �ݴ�� ����)
					nodes.get(i-1).checked = false;
					// ť�� �߰�
					queue.add(i);
				}
			}
		}		
	}

	// ���� Ŭ����
	static class Node{
		int value; // ��
		boolean checked; // �湮����
		LinkedList<Integer> neightbor; // �̿��� ������ ����Ʈ

		Node(int value){
			this.value = value; // �Է¹��� ������ ���� ����
			checked = false; // default�� false�� ����
			neightbor = new LinkedList<>(); // ����Ʈ �ʱ�ȭ
		}
	}
}
