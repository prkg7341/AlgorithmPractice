package Structure;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(0); // index������ �� �ڿ�
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(3,3);
		list.remove(4);
		list.get(3);		

		// Ž�� 1��
		Iterator <Integer> it= list.iterator();
		while(it.hasNext()){
		    System.out.println(it.next());       
		}

		// Ž�� 2��
		for(int value : list){
		    System.out.println(value);
		}
	}
}