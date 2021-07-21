package NHNgodo;

public class NG2 {
	public int solution(int page, int[] broken){

		// +또는 -로만 채널을 이동할때 값을 미리 리턴값에 저장
		int ret = Math.abs(page-100);		

		// 고장난  숫자키를 boolean으로 저장하는 배열 선언 및 초기화
		boolean[] brk = new boolean[10];
		for(int i = 0; i < broken.length; i++) {
			brk[broken[i]] = true;
		}

		// page 최대값의 2배를 적용하여 브루트포스 알고리즘 사용
		for(int i=0; i<=1000000; i++) {
			// 반복문 내에서 사용할 채널
			int temp = i;
			// 채널이동을 위해 눌러야하는 횟수
			int length = 0;
			// 채널이 0일때 예외처리
			if(i == 0){
				if(brk[0]) length = 0;
				else length = 1;
			} 
			// 해당 채널로 이동할 수 있는지 여부 판별
			while (temp > 0) {
				if(brk[temp % 10]){
					length = 0;
					break;
				}
				length++;
				temp /= 10;
			}
			// 해당 채널로 이동할 수 있다면 최솟값을 구해 ret값 업데이트
			if (length > 0) {
				ret = Math.min(ret, length + Math.abs(i-page));
			}
		}
		return ret;
	}
}
