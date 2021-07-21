package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		ArrayList<Integer> list = new ArrayList<>(n);

		for(int i=0 ; i<n ; i++){
			list.add(i+1);
		}
		sb.append("<");
		int index = 0;
		while(!list.isEmpty()){
			index += m-1;
			while(index>=list.size()){
				index -= list.size();
			}
			sb.append(list.get(index)+", ");
			list.remove(index);			
		}
		sb.replace(sb.length()-2, sb.length()-1, ">");
		System.out.println(sb.toString());
	}
}
