package Kakao2019;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {3, 1, 2}, 5));
	}

	public int solution(int[] food_times, long k) {

		int answer = 0;

		ArrayList<Food> foods = new ArrayList<>();

		for(int i=1 ; i<=food_times.length ; i++) {
			foods.add(new Food(food_times[i-1], i));
		}

		int index = 0;

		Collections.sort(foods);

		int temp = 0;

		while(k>=food_times.length) {
			k -= food_times.length;
			temp++;
			while(!foods.isEmpty() && foods.get(0).num==temp) {
				foods.remove(0);
			}
			if(foods.isEmpty()) {
				answer = -1;
				break;
			}
		}

		for(int i=0 ; i<k ; i++) {
			if(foods.isEmpty()) {
				answer = -1;
				break;
			}
			foods.get(index).num--;
			if(foods.get(index).num==temp) {
				foods.remove(index);
			}
			else {
				index++;
			}
			if(index==foods.size()) {
				index = 0;
			}
		}

		if(index!=-1) {
			answer = foods.get(index).index;
		}

		return answer;
	}

	static class Food implements Comparable<Food>{
		int num;
		int index;
		Food(int num, int index){
			this.num = num;
			this.index = index;
		}
		@Override
		public int compareTo(Food o) {
			// TODO Auto-generated method stub
			return this.num-o.num;
		}
	}
}
