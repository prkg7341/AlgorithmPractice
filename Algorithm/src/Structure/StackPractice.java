package Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StackPractice {

	public static void main(String[] args) throws NumberFormatException, IOException{
		ArrayList<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String input = br.readLine();
			switch(input.split(" ")[0]){
			case "push": push(list, Integer.parseInt(input.split(" ")[1])); break;
			case "pop": pop(list); break;
			case "size": size(list); break;
			case "empty": empty(list); break;
			case "top": top(list); break;

			}
		}
	}

	static void push(ArrayList<Integer> list, int n){
		list.add(n);
	}

	static void pop(ArrayList<Integer> list){
		if(list.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(list.get(list.size()-1));
			list.remove(list.size()-1);
		}
	}
	static void size(ArrayList<Integer> list){
		System.out.println(list.size());
	}
	static void empty(ArrayList<Integer> list){
		if(list.size()==0){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
	}
	static void top(ArrayList<Integer> list){
		if(list.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(list.get(list.size()-1));
		}
	}
}
