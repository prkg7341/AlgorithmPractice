package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] ar = new int[n][2];
		int count = 0;
		int max = 0;

		for(int i=0 ; i<n ; i++){
			String st = br.readLine();
			int a = Integer.parseInt(st.split(" ")[0]);
			int b = Integer.parseInt(st.split(" ")[1]);
			ar[i][0] = a;
			ar[i][1] = b-a;
			if(max<(ar[i][0]+ar[i][1])){
				max = ar[i][0]+ar[i][1];
			}
		}
		
		Arrays.sort(ar, new Comparator<int[]>() {
			// Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
				// 내림자순 정렬을 하고 싶다면 o2와 o1의 위치를 바꿔줍니다
				// return o2[1] - o1[1];
			}
		});

		int[] time = new int[max+1];

		for(int i=0 ; i<n ; i++){
			if(ar[i][1]==0) {
				count++;
			}
			else{	
				int sum=0;
				for(int j=ar[i][0] ; j<ar[i][0]+ar[i][1] ; j++){
					sum += time[j];
				}
				if(sum==0){
					for(int j=ar[i][0] ; j<ar[i][0]+ar[i][1] ; j++){
						time[j] = 1;
					}				
					count++;
				}
			}
		}

		bw.write(count+"");
		bw.flush();
		bw.close();

	}

}
