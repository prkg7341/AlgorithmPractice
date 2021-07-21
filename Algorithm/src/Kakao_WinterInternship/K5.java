package Kakao_WinterInternship;

public class K5 {
	public int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;

		int start_index = 0;
		int end_index = k-1;
		int next_start_index = 0;
		int next_end_index = k-1;

		while(start_index<stones.length && end_index<stones.length){
			int sub_max = 0;
			for(int i=start_index ; i<=end_index ; i++){
				if(stones[i]>=sub_max){
					sub_max = Math.max(sub_max, stones[i]);
					next_start_index = i+1;
					next_end_index = next_start_index+k-1;
				}
			}
			answer = Math.min(answer, sub_max);
			start_index = next_start_index;
			end_index = next_end_index;
		}
		return answer;
	}
}
