package Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Line3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		String[][] table = new String[n][input.length];
		int nl = input.length;

		for(int j=0 ; j<input.length ; j++){
			table[0][j] = input[j];
		}

		for(int i=1 ; i<n ; i++){
			input = br.readLine().split(" ");
			int index = Integer.parseInt(input[0]);
			for(int j=0 ; j<input.length ; j++){
				table[index][j] = input[j];
			}
		}

		int m = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		String[][] table2 = new String[n][input.length];
		int ml = input.length;
		for(int j=0 ; j<input.length ; j++){
			table2[0][j] = input[j];
		}
		for(int i=1 ; i<m ; i++){
			input = br.readLine().split(" ");
			int index = Integer.parseInt(input[0]);
			if(index>=n) continue;
			for(int j=0 ; j<input.length ; j++){
				table2[index][j] = input[j];
			}
		}
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<nl ; j++){
				sb.append(table[i][j]+" ");
			}
			for(int j=1 ; j<ml ; j++){
				sb.append(table2[i][j]+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
