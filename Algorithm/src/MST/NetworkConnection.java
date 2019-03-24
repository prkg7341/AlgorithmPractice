package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NetworkConnection {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int computer = Integer.parseInt(br.readLine());

		int edge = Integer.parseInt(br.readLine());

		int[] root = new int[computer+1];
		int[][] edges = new int[edge+1][3];

		for(int i=1 ; i<=edge ; i++){
			String[] input = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(input[0]);
			edges[i][1] = Integer.parseInt(input[1]);
			edges[i][2] = Integer.parseInt(input[2]);
		}

		if(computer==1) {
			System.out.print(0);
			return;
		}

		Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		int count = 0;
		int sum = 0;

		for(int i=1 ; i<=edge && count!=computer ; i++){
			if(edges[i][0]==edges[i][1]) continue;

			if(root[edges[i][0]]==0 && root[edges[i][1]]==0){
				root[edges[i][0]] = edges[i][0];
				root[edges[i][1]] = edges[i][0];
				count++;
				sum+=edges[i][2];
			}
			else if(root[edges[i][0]]==0){
				root[edges[i][0]] = root[edges[i][1]];
				count++;
				sum+=edges[i][2];
			}
			else if(root[edges[i][1]]==0){
				root[edges[i][1]] = root[edges[i][0]];
				count++;
				sum+=edges[i][2];
			}
			else if(root[edges[i][0]] != root[edges[i][1]]){
				int from = root[edges[i][0]];
				int to = root[edges[i][1]];
				for(int j=1 ; j<=computer ; j++){
					if(root[j]==from){
						root[j] = to;
					}
				}
				count++;
				sum+=edges[i][2];
			}
			else{
				continue;
			}
		}
		System.out.print(sum);
	}
}