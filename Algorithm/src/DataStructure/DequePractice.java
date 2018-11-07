package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DequePractice {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		ArrayList<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String input = br.readLine();
			switch(input.split(" ")[0]){
			case "push_front": push_front(list, Integer.parseInt(input.split(" ")[1])); break;
			case "push_back": push_back(list, Integer.parseInt(input.split(" ")[1])); break;
			case "pop_front": pop_front(list); break;
			case "pop_back": pop_back(list); break;
			case "size": size(list); break;
			case "empty": empty(list); break;
			case "front": front(list); break;
			case "back": back(list); break;

			}
		}
	}

	static void push_front(ArrayList<Integer> list, int n){
		list.add(0,n);
	}
	static void push_back(ArrayList<Integer> list, int n){
		list.add(n);
	}

	static void pop_front(ArrayList<Integer> list){
		if(list.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(list.get(0));
			list.remove(0);
		}
	}
	static void pop_back(ArrayList<Integer> list){
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
	static void front(ArrayList<Integer> list){
		if(list.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(list.get(0));
		}
	}
	static void back(ArrayList<Integer> list){
		if(list.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(list.get(list.size()-1));
		}
	}
}
