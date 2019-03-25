package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			int count = 0;
			int[] importances = new int[10];

			String[] input = br.readLine().split(" ");
			int paper = Integer.parseInt(input[0]);
			int index = Integer.parseInt(input[1]);

			int[] q = new int[paper];

			input = br.readLine().split(" ");

			for(int i=0 ; i<paper; i++){
				int now = Integer.parseInt(input[i]);
				q[i] = now;
				importances[now]++;
			}
			int imp = q[index];

			int tempI = paper-1;

			for(int i=9 ; i>imp ; i--){
				if(importances[i]==0){
					continue;
				}
				else{
					count+=importances[i];
					while(q[tempI]!=i){
						tempI = tempI==0 ? paper-1 : --tempI;
					}
				}
			}
			while(true){
				tempI = tempI==paper-1 ? 0 : ++tempI;
				if(q[tempI]==imp) count++;
				if(tempI==index) break;
			}
			sb.append(count+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}