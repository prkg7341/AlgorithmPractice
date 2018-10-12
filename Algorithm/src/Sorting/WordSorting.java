package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class WordSorting {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] ar = new String[n][2];
		
		for(int i=0 ; i<n ; i++){
			String temp = br.readLine();
			ar[i][0] = temp;
			ar[i][1] = temp.length()+"";			
		}

		Arrays.sort(ar, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });
		
		String[] ar2;
		int count=0;
		
		for(int i=1 ; i<n ; i++){
			if(Integer.parseInt(ar[i][1])==Integer.parseInt(ar[i-1][1])){
				count++;
			}
		}
			

	}

}
