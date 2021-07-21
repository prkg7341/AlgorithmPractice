package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_16397 {	

	static int MAX;
	static int dest;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		MAX = 99999;
		int start = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);
		dest = Integer.parseInt(input[2]);

		visit = new boolean[MAX+1];

		Queue<Pair> q = new LinkedList<>();
		visit[start] = true;
		q.add(new Pair(start, 0));

		while(!q.isEmpty()){
			Pair now = q.poll();

			if(now.value==dest){
				System.out.print(now.count);
				return;
			}

			testA(now, q, num);
			testB(now, q, num);
		}
		System.out.print("ANG");
	}
	private static void testA(Pair now, Queue<Pair> q, int num) {
		int newV = now.value+1;
		int newC = now.count+1;
		if(newV<=MAX){
			if(newC<=num && !visit[newV]){
				visit[newV] = true;
				q.add(new Pair(newV, newC));
			}
		}		
	}
	private static void testB(Pair now, Queue<Pair> q, int num) {
		int newV = now.value*2;
		int newC = now.count+1;

		if(newV<=MAX){
			if(newV>9999){
				newV -= 10000;
			}
			else if(newV>999){
				newV -= 1000;
			}
			else if(newV>99){
				newV -= 100;
			}
			else if(newV>9){
				newV -= 10;
			}
			else{
				newV -= 1;
			}
			if(newC<=num && newV>=0 && !visit[newV]){
				visit[newV] = true;
				q.add(new Pair(newV, newC));
			}
		}
	}
	static class Pair{
		int value;
		int count;
		Pair(int value, int count){
			this.value = value;
			this.count = count;
		}
	}
}
