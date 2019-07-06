package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakingLine {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(input[i]);

			list.add(list.size()-now, i+1);
		}
		for(int num : list){
			sb.append(num).append(" ");
		}
		System.out.print(sb.toString());
	}
}
