package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort3_CountingSort {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new  StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] count = new int[10001];

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(br.readLine());
			count[now]++;
		}

		int index=1;

		for(int i=0 ; i<n ; i++){
			while(count[index]==0) index++;
			sb.append(index+"\n");
			count[index]--;
		}

		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}