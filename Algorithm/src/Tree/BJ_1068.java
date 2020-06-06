package Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1068 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();

		for(int i=0 ; i<n ; i++) {
			nodes.put(i, new ArrayList<Integer>());
		}		

		for(int i=0 ; i<n ; i++) {
			int parent = Integer.parseInt(input[i]);
			if(parent!=-1){
				nodes.get(parent).add(i);
			}
		}

		int removed = Integer.parseInt(br.readLine());

		int ans = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(removed);

		while(!q.isEmpty()){
			int node = q.poll();			
			for(int i : nodes.remove(node)) q.add(i);
		}

		for (Integer key : nodes.keySet()) {
			if(nodes.get(key).size()==0) ans++;
			else if(nodes.get(key).size()==1 && nodes.get(key).get(0)==removed) ans++;
		}

		bw.write(String.valueOf(ans));

		bw.flush();
	}
}
