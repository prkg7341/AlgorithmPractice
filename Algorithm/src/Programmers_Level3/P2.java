package Programmers_Level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++) {
			ar[i] = Integer.parseInt(input[i]);
		}

		int M = Integer.parseInt(br.readLine());

		bw.write(String.valueOf(solution(ar, M)));

		bw.flush();
	}


	public static int solution(int[] budgets, int M) {
		long sum = 0;
		int max = 0;

		for(int i=0 ; i<budgets.length ; i++){
			sum += budgets[i];
			max = Math.max(max, budgets[i]);
		}

		if(sum<=M) return max;
		else{
			return bs(0, max, budgets, M);
		}
	}

	private static int bs(int min, int max, int[] budgets, int M) {
		int mid = (min+max)/2;

		if(min>max){
			return max;
		}
		else{
			if(check(mid, budgets, M))
				return bs(mid+1, max, budgets, M);
			else
				return bs(min, mid-1, budgets, M);
		}
	}

	private static boolean check(int mid, int[] budgets, int M) {

		long sum = 0;

		for(int i=0 ; i<budgets.length ; i++){
			if(budgets[i]>mid) sum += mid;
			else sum += budgets[i];
		}

		if(sum<=M)
			return true;
		else		
			return false;
	}
}
