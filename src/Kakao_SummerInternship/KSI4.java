package Kakao_SummerInternship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KSI4 {
	public int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 987654321;

		Node[] nodes = new Node[n+1];

		for(int i=1 ; i<=n ; i++) {
			nodes[i] = new Node(i);
		}

		for(int i=0 ; i<traps.length ; i++) {
			nodes[traps[i]].istrap = true;
		}

		int[][] road = new int[n+1][n+1];

		for(int i=0 ; i<roads.length ; i++) {
			int from = roads[i][0];
			int to = roads[i][1];
			int distance = roads[i][2];

			if(road[from][to]==0)
				road[from][to] = distance;
			else
				road[from][to] = Math.min(road[from][to], distance);
		}

		int[][] visit = new int[n+1][2];
		for(int[] ar : visit) Arrays.fill(ar, 123456789);

		Queue<Context> q = new LinkedList<>();

		visit[start][0] = 0;
		q.add(new Context(start, 0));

		while(!q.isEmpty()) {
			Context context = q.poll();
			Node now = nodes[context.num];
			
			if(now.istrap) {
				for(int i=1 ; i<=n ; i++) {
					swap(road, now.value, i);
				}
				now.trapped++;
			}

			for(int i=1 ; i<=n ; i++) {
				if(road[now.value][i]==0) continue;
				
				int newD = context.distance+road[now.value][i];				
				if(newD>=answer) continue;
				
				if(visit[i][nodes[i].trapped%2]>newD) {
					visit[i][nodes[i].trapped%2] = newD;
					if(i==end) {
						answer = Math.min(answer, visit[end][nodes[i].trapped%2]);
					}
					else q.add(new Context(i, newD));
				}
				else if(nodes[i].istrap && visit[i][(nodes[i].trapped+1)%2]>newD) {
					visit[i][(nodes[i].trapped+1)%2] = newD;
					if(i==end) {
						answer = Math.min(answer, visit[end][nodes[i].trapped%2]);
					}
					else q.add(new Context(i, newD));
				}
			}
		}

		return answer;
	}

	private void swap(int[][] road, int x, int y){
		int temp = road[x][y];
		road[x][y] = road[y][x];
		road[y][x] = temp;
	}
	
	static class Context{
		int distance;
		int num;
		Context(int num, int distance){
			this.distance = distance;
			this.num = num;
		}
	}

	static class Node{
		int value;
		boolean istrap = false;
		int trapped = 0;
		Node(int value){
			this.value = value;
		}
	}
}
