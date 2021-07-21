package NHNgodo_prac;

public class NG1 {
	public long solution(int n){
		
		// dp를 활용해 피보나치 수열을 구하기 위해 배열을 만듭니다.
		long[] ar = new long[n+1];
		
		// n이 0일때의 예외처리를 해준뒤, 첫번째 값을 입력합니다.
		if(n>0) ar[1] = 1;
		
		// 피보나치 수열을 구합니다.
		for(int i=2 ; i<ar.length ; i++) {
			ar[i] = ar[i-1] + ar[i-2];
		}
		
		// 값을 리턴합니다.
        return ar[n];
    }
}
