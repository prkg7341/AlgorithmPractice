package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortingWithAge {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int num = Integer.parseInt(input[0]);

		Input[] ar = new Input[num];
		for(int i=0 ; i<num ; i++) {
			input = br.readLine().split(" ");
			ar[i] = new Input(Integer.parseInt(input[0]), input[1]);
		}
		Arrays.sort(ar);
		for(Input in : ar) {
			sb.append(in.toString()).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());		
	}

	static class Input implements Comparable<Input>{
		int age;
		String name;
		Input(int age, String name){
			this.age = age;
			this.name = name;
		}
		public String toString() {
			return age+" "+name;
		}
		@Override
		public int compareTo(Input o) {
			return this.age - o.age;
		}
	}
}
