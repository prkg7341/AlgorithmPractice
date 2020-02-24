package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2667 {

	static LinkedList<Integer> list = new LinkedList<>();
	static int size;
	static int ar[][];
	static boolean checked[][];
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());

		ar = new int[size][size];
		checked = new boolean[size][size];
		int countAll = 0;

		for(int i=0 ; i<size ; i++){
			String[] input = br.readLine().split("");
			for(int j=0 ; j<size ; j++){
				ar[i][j] = Integer.parseInt(input[j]);
			}
		}

		for(int i=0 ; i<size ; i++){
			for(int j=0 ; j<size ; j++){
				if(ar[i][j]==1 && !checked[i][j]){
					bfs(i,j);
					countAll++;
				}
			}
		}
		Integer[] ar = list.toArray(new Integer[list.size()]); 

		Arrays.sort(ar);

		System.out.println(countAll);
		for(int i : ar){
			System.out.println(i);
		}

	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x,y));
		checked[x][y] = true;

		int count=1;

		while(!queue.isEmpty()){
			Position now = queue.poll();

			for(int i=0 ; i<4 ; i++){
				int nextX = now.x+dx[i];
				int nextY = now.y+dy[i];
				if(nextX!=-1 && nextX!=size && nextY!=-1 && nextY!=size){
					if(ar[nextX][nextY]==1 && !checked[nextX][nextY]){
						Position next = new Position(nextX, nextY);
						checked[nextX][nextY] = true;
						queue.add(next);
						count++;
					}
				}
			}
		}
		list.add(count);
	}
	static class Position{
		int x;
		int y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
