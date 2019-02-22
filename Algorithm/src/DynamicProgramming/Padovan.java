package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Padovan {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		ArrayList<Long> list = new ArrayList<>();
		list.add((long) 1);
		list.add((long) 1);
		list.add((long) 1);
		list.add((long) 2);
		list.add((long) 2);
		list.add((long) 3);
		list.add((long) 4);
		list.add((long) 5);
		list.add((long) 7);
		list.add((long) 9);

		for(int i=0 ; i<n ; i++){
			int input = Integer.parseInt(br.readLine());
			if(input<=list.size()){
				sb.append(list.get(input-1)+"\n");
			}
			else{
				while(input>list.size()){
					list.add(list.get(list.size()-3)+list.get(list.size()-2));
				}
				sb.append(list.get(input-1)+"\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
