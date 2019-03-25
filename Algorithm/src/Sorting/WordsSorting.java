package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class WordsSorting {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<String>> list = new ArrayList<>(50);

		for(int i=0 ; i<50 ; i++){
			list.add(new ArrayList<String>());
		}

		for(int i=0 ; i<n ; i++){
			String input = br.readLine();
			list.get(input.length()-1).add(input);
		}
		for(int i=0 ; i<50 ; i++){
			if(list.get(i).size()!=0){
				Collections.sort(list.get(i));
				for(int j=0 ; j<list.get(i).size() ; j++){
					if(j==0 || list.get(i).get(j).compareTo(list.get(i).get(j-1))!=0)
						sb.append(list.get(i).get(j)+"\n");
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}