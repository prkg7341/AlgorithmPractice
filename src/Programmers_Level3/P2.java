package Programmers_Level3;

public class P2 {

	public int solution(int[] budgets, int M) {
		long sum = 0;
		int max = 0;

		for(int i=0 ; i<budgets.length ; i++){
			sum += budgets[i];
			max = Math.max(max, budgets[i]);
		}

		if(sum<=M) return max;
		else{
			return bs(0, max, budgets, M);
		}
	}

	private int bs(int min, int max, int[] budgets, int M) {
		int mid = (min+max)/2;

		if(min>max){
			return max;
		}
		else{
			if(check(mid, budgets, M))
				return bs(mid+1, max, budgets, M);
			else
				return bs(min, mid-1, budgets, M);
		}
	}

	private boolean check(int mid, int[] budgets, int M) {

		long sum = 0;

		for(int i=0 ; i<budgets.length ; i++){
			if(budgets[i]>mid) sum += mid;
			else sum += budgets[i];
		}

		if(sum<=M)
			return true;
		else		
			return false;
	}
}
