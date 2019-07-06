package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SDS_2_1_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine().split(" ")[0]);

		for(int tt=1 ; tt<=t ; tt++){
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);

			int[] ar = new int[k];

			input = br.readLine().split(" ");

			int color = 1;
			int max = 0;
			int zeros = 0;

			for(int i=0 ; i<n ; i++){
				int now = Integer.parseInt(input[i]);

				if(now==0){
					zeros++;
				}
				else{
					if(zeros!=0){
						if(now==color){
							ar[now-1] += zeros;
						}
						else{
							int first_zeros = zeros;
							LinkedList<Integer> list = new LinkedList<>();
							for(int j=now-1 ; j>=color ; j--){
								list.add(j);
								if(ar[j]!=0){
									break;
								}
								else{
									zeros--;
								}
							}
							zeros++;
							if(zeros>first_zeros) zeros = first_zeros;
							for(int index : list){
								ar[index] += zeros;
							}
						}
						zeros = 0;
					}
					color = now;
					ar[color-1]++;
				}
			}
			if(zeros!=0){
				int first_zeros = zeros;
				LinkedList<Integer> list = new LinkedList<>();
				for(int j=k-1 ; j>=0 ; j--){
					list.add(j);
					if(ar[j]!=0){
						break;
					}
					else{
						zeros--;
					}
				}
				zeros++;
				if(zeros>first_zeros) zeros = first_zeros;
				for(int index : list){
					ar[index] += zeros;
				}
			}
			for(int j=0 ; j<ar.length ; j++){
				max = Math.max(max, ar[j]);
			}
			sb.append("#").append(tt).append(" ").append(max).append(" \n");
		}
		System.out.print(sb.toString());
	}
}
