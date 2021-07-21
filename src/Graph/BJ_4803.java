package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class BJ_4803 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int tt=1 ; ; tt++){
			String[] input = br.readLine().split(" ");
			int nodes = Integer.parseInt(input[0]);
			int edges = Integer.parseInt(input[1]);

			if(nodes==0 && edges==0) break;

			int[] label = new int[nodes+1];			
			HashMap<Integer, ArrayList<Integer>> trees = new HashMap<>();

			for(int i=0 ; i<=nodes ; i++){
				label[i] = i;
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				trees.put(i, list);
			}

			for(int i=0 ; i<edges ; i++){
				input = br.readLine().split(" ");

				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);

				// 루프 생길때
				if(label[a] == label[b]){
					if(label[a]!=0){
						ArrayList<Integer> list = new ArrayList<>();
						for(int temp : trees.remove(label[b])){
							list.add(temp);						
							label[temp] = 0;
						}
						trees.put(0, list);
					}
				}
				else{
					if(label[a]>label[b]){
						int temp = a;
						a = b;
						b = temp;
					}

					ArrayList<Integer> list = new ArrayList<>(trees.remove(label[a]));
					for(int temp : trees.remove(label[b])){
						list.add(temp);						
						label[temp] = label[a];
					}
					trees.put(label[a], list);
				}
			}

			trees.remove(0);

			bw.write("Case "+tt+": ");

			if(trees.size()==0){
				bw.write("No trees.\n");
			}
			else if(trees.size()==1){
				bw.write("There is one tree.\n");
			}
			else{
				bw.write("A forest of "+trees.size()+" trees.\n");
			}
		}

		bw.flush();
	}
}
