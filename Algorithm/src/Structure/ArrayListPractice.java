package Structure;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(0); // index없으면 맨 뒤에
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(3,3);
		list.remove(4);
		list.get(3);		

		// 탐색 1번
		Iterator <Integer> it= list.iterator();
		while(it.hasNext()){
		    System.out.println(it.next());       
		}

		// 탐색 2번
		for(int value : list){
		    System.out.println(value);
		}
	}
}