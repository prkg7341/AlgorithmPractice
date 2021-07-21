package Kakao2020_intern;

import java.util.ArrayList;

public class K2 {
	public long solution(String expression) {
		long answer = 0;

		int index = 0;

		ArrayList<Pair> list = new ArrayList<>();

		for(int i=0 ; i<expression.length() ; i++) {
			index = i;
			try {
				while(expression.charAt(i)>='0' && expression.charAt(i)<='9') {
					i++;
				}
			} catch(Exception e) {
				// i--????????
			}			

			if(i<expression.length()) {
				if(expression.charAt(i)=='+') {
					list.add(new Pair(Integer.parseInt(expression.substring(index, i)), 1));
				}
				else if(expression.charAt(i)=='-') {
					list.add(new Pair(Integer.parseInt(expression.substring(index, i)), -1));
				}
				else
					list.add(new Pair(Integer.parseInt(expression.substring(index, i)), 0));
			}
			else list.add(new Pair(Integer.parseInt(expression.substring(index, i)), 2));
		}

		answer = Math.max(Math.abs(dnc(0, list, new int[] {-1, 0, 1})), answer);
		answer = Math.max(Math.abs(dnc(0, list, new int[] {-1, 1, 0})), answer);
		answer = Math.max(Math.abs(dnc(0, list, new int[] {0, 1, -1})), answer);
		answer = Math.max(Math.abs(dnc(0, list, new int[] {0, -1, 1})), answer);
		answer = Math.max(Math.abs(dnc(0, list, new int[] {1, 0, -1})), answer);
		answer = Math.max(Math.abs(dnc(0, list, new int[] {1, -1, 0})), answer);

		return answer;
	}

	private long dnc(int order, ArrayList<Pair> list_, int[] ar) {

		ArrayList<Pair> list = new ArrayList<>();

		for(Pair p : list_) list.add(p);

		if(list.size()==1) {
			//			System.out.println(list.get(0).value);
			return list.get(0).value;
		}

		int temp = ar[order];

		for(int i=0 ; i<list.size() ; i++) {
			if(list.size()==1) {
				//				System.out.println(list.get(0).value);
				return list.get(0).value;
			}
			if(i!=list.size()-1 && list.get(i).ex==temp) {
				if(temp==-1) {
					list.add(i, new Pair(list.remove(i).value-list.get(i).value, list.remove(i).ex));
				}
				if(temp==0) {
					list.add(i, new Pair(list.remove(i).value*list.get(i).value, list.remove(i).ex));
				}
				if(temp==1) {
					list.add(i, new Pair(list.remove(i).value+list.get(i).value, list.remove(i).ex));
				}
				i--;
			}
		}

		return dnc(order+1, list, ar);
	}

	static class Pair{
		long value;
		int ex;
		Pair(long value, int ex){
			this.value = value;
			this.ex = ex;
		}
	}
}
