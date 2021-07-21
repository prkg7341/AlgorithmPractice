package Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Line5 {

	static int c;
	static int b;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		c = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);

		bfs();
	}

	private static void bfs() {

		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(c,b,0));

		while(!queue.isEmpty()){
			Pair now = queue.poll();
			int x = now.x;
			int y = now.y;
			int count = now.count;

			if(x==y){
				System.out.print(now.count);
				return;
			}

			count++;

			int newX = x+count;
			int y1 = y-1;
			int y2 = y+1;
			int y3 = 2*y;

			if(newX<=200000){
				if(y1>=0 ){
					queue.add(new Pair(newX,y1,count));
				}
				if(y2<=200000 ){
					queue.add(new Pair(newX,y2,count));
				}
				if(y3<=200000){
					queue.add(new Pair(newX,y3,count));
				}
			}
		}
		System.out.print(-1);
	}

	static class Pair{
		int x;
		int y;
		int count;
		Pair(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
