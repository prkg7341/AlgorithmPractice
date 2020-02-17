package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1918 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] input = br.readLine().toCharArray();

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}

		Stack<Double> st = new Stack<>();

		for(int i=0 ; i<input.length ; i++){
			char now = input[i];

			if(now>='A' && now<='Z'){
				st.push((double)ar[(int)now-65]);
			}

			else{
				double b = st.pop();
				double a = st.pop();
				double temp = 0;
				switch(now){
				case '+':
					temp = a+b; break;
				case '-':
					temp = a-b; break;
				case '*':
					temp = a*b; break;
				case '/':
					temp = a/b; break;
				}
				st.push(temp);
			}
		}
		System.out.print(String.format("%.2f", st.pop()));
	}
}