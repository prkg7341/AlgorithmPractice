package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideNSeek {

	static int start;
	static int end;
	static int[] ar = new int[100001];
	static boolean[] checked = new boolean[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);

		bfs();
	}

	private static void bfs() {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(start,0));
		while(!queue.isEmpty()){
			Position now = queue.poll();
			int index = now.index;
			int count = now.count;
			if(index==end){
				System.out.println(count);
				return;
			}
			if(index-1!=-1 && !checked[index-1]){
				checked[index-1] = true;
				queue.add(new Position(index-1, count+1));
			}
			if(index+1!=100001 && !checked[index+1]){
				checked[index+1] = true;
				queue.add(new Position(index+1, count+1));
			}
			if(index*2<=100000 && !checked[index*2]){
				checked[2*index] = true;
				queue.add(new Position(index*2, count+1));
			}
		}
	}
	static class Position{
		int index;
		int count;
		Position(int index, int count){
			this.index = index;
			this.count = count;
		}
	}
}
