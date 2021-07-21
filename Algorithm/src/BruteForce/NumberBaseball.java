package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumberBaseball {

	static int[][] score;
	static int count=0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		score = new int[1000][2];

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");

			int num = Integer.parseInt(input[0]);
			int strike = Integer.parseInt(input[1]);
			int ball = Integer.parseInt(input[2]);

			list.add(num);
			score[num][0] = strike;
			score[num][1] = ball;
		}

		for(int num=111 ; num<1000 ; num++){
			int first = num/100;
			int second = num/10%10;
			int third = num%10;
			if(second==0 || third==0) continue;
			if(first==second || first==third || second==third) continue;
			compare(list, num);
		}
		System.out.print(count);
	}

	static void compare(ArrayList<Integer> list, int po){

		int y1 = po/100;
		int y2 = po/10%10; 
		int y3 = po%10;

		for(int num : list){
			int strike=0;
			int ball=0;
			int x1 = num/100;
			int x2 = num/10%10; 
			int x3 = num%10;

			if(x1==y1) strike++;			
			else{
				if(x1==y2) ball++;
				if(x1==y3) ball++;
			}

			if(x2==y2) strike++;
			else{
				if(x2==y1) ball++;
				if(x2==y3) ball++;
			}

			if(x3==y3) strike++;
			else{
				if(x3==y1) ball++;
				if(x3==y2) ball++;
			}
			if(score[num][0]!=strike || score[num][1]!=ball) return;
		}
		count++;
	}
}