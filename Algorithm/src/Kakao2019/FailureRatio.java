package Kakao2019;

import java.util.Arrays;

public class FailureRatio {

	public static void main(String[] args){
		FailureRatio s = new FailureRatio();
		System.out.println(Arrays.toString(s.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(s.solution(4, new int[] {4, 4, 4, 4, 4})));
	}

	public int[] solution(int N, int[] stages) {

		Arrays.parallelSort(stages);
		Stage[] res = new Stage[N];

		for(int i=0 ; i<N ; i++) {
			res[i] = new Stage(i+1);
		}

		int users = 0;

		for(int i=stages.length-1 ; i>=0 ; i--) {
			users++;
			int stage_now = stages[i];
			if (stage_now==N+1){
				continue;
			}
			else {
				res[stage_now-1].f_users++;
				if(i==stages.length-1) {
				}
				else if(stage_now==stages[i+1]) {
				}
				else {
					for(int j=stage_now+1 ; j<=N&&res[j-1].users==0 ; j++) {
						res[j-1].users = users-1;
					}
				}
				if(i==0) {
					for(int j=i ; j<N&&res[j].users==0.0 ; j++) {
						res[j].users = users;
					}
				}
			}
		}

		for(Stage s : res) {
			System.out.println(s.index+": "+s.f_users+"/"+s.users);
		}
		Arrays.sort(res);

		int[] answer = new int[N];

		for(int i=0 ; i<N ; i++) {
			answer[i] = res[i].index;
		}

		return answer;
	}

	static class Stage implements Comparable<Stage>{
		double users;
		double f_users;
		int index;
		Stage(int index){
			users = 0;
			f_users = 0;
			this.index = index;
		}

		@Override
		public int compareTo(Stage o) {
			int ret = 0;
			int result = -Double.compare(this.f_users/this.users, o.f_users/o.users);
			if(result==0) {
				ret = this.index> o.index? 1 : -1;
			}
			else {
				ret = result;
			}		
			return ret;
		}
	}
}
