package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Virus {

	static Computer[] computers;
	static int count=-1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int com = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());

		computers = new Computer[com];

		for(int i=0 ; i<com ; i++){
			computers[i] = new Computer(i+1);
		}

		for(int i=0 ; i<edge ; i++){
			String[] input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);

			computers[node1-1].neighbor.add(computers[node2-1]);
			computers[node2-1].neighbor.add(computers[node1-1]);
		}

		bfs();

		System.out.println(count);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Computer> queue = new LinkedList<>();

		queue.add(computers[0]);
		computers[0].checked = true;

		while(!queue.isEmpty()){
			Computer now = queue.poll();
			count++;

			Iterator<Computer> it = now.neighbor.iterator();
			while(it.hasNext()){
				Computer next = it.next();
				if(!next.checked){
					next.checked = true;
					queue.add(next);
				}
			}
		}		
	}

	static class Computer{
		int value;
		boolean checked;
		ArrayList<Computer> neighbor;

		Computer(int value){
			this.value = value;
			neighbor = new ArrayList<>();
		}
	}
}
