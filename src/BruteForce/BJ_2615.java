package BruteForce;

import java.util.Scanner;

public class BJ_2615 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		// 구현하세요.

		int[][] ar = new int[19][19]; // 바둑판을 위한 배열 선언

		// 배열에 스캐너로 읽어온 input 저장
		for(int i=0 ; i<ar.length ; i++) {
			for(int j=0 ; j<ar.length ; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		sc.close();

		// 2차원 배열을 탐색하면서 승패여부 탐색
		for(int i=0 ; i<ar.length ; i++) {
			for(int j=0 ; j<ar.length ; j++) {

				int now = ar[i][j]; // 비교대상이 될 돌을 저장하는 변수

				// 알이 없는 자리이면 pass
				if(now==0) continue;

				// 1 우하 (반대편 첫번째돌이 같은지 체크)
				if(!(i>0 && j>0 && ar[i-1][j-1]==now) && (i+4<ar.length && j+4<ar.length)) {
					// 5번째 돌까지 같은지 탐색
					boolean same = true;
					for(int d=1 ; d<=4 ; d++) {
						if(ar[i+d][j+d]!=now) {
							same = false;
							break;
						}
					}
					// 5번째 돌까지 같고, 6번째 돌이 없거나 다르면 승리
					if(same && ((i+5==ar.length || j+5==ar.length) || ar[i+5][j+5]!=now)) {
						System.out.println(now);
						System.out.println((i+1)+" "+(j+1));
						return;
					}
				}
				// 2 우 (반대편 첫번째돌이 같은지 체크)
				if(!(j>0 && ar[i][j-1]==now) && (j+4<ar.length)) {
					boolean same = true;
					for(int d=1 ; d<=4 ; d++) {
						if(ar[i][j+d]!=now) {
							same = false;
							break;
						}
					}
					// 5번째 돌까지 같고, 6번째 돌이 없거나 다르면 승리
					if(same && ((j+5==ar.length) || ar[i][j+5]!=now)) {
						System.out.println(now);
						System.out.println((i+1)+" "+(j+1));
						return;
					}
				}				
				// 3 우상 (반대편 첫번째돌이 같은지 체크)
				if(!(i<ar.length-1 && j>0 && ar[i+1][j-1]==now) && (i-4>=0 && j+4<ar.length)) {
					boolean same = true;
					for(int d=1 ; d<=4 ; d++) {
						if(ar[i-d][j+d]!=now) {
							same = false;
							break;
						}
					}
					// 5번째 돌까지 같고, 6번째 돌이 없거나 다르면 승리
					if(same && ((i-5<0 || j+5==ar.length) || ar[i-5][j+5]!=now)) {
						System.out.println(now);
						System.out.println((i+1)+" "+(j+1));
						return;
					}
				}				
				// 4 하 (반대편 첫번째돌이 같은지 체크)
				if(!(i>0 && ar[i-1][j]==now) && (i+4<ar.length)) {
					boolean same = true;
					for(int d=1 ; d<=4 ; d++) {
						if(ar[i+d][j]!=now) {
							same = false;
							break;
						}
					}
					// 5번째 돌까지 같고, 6번째 돌이 없거나 다르면 승리
					if(same && ((i+5==ar.length) || ar[i+5][j]!=now)) {
						System.out.println(now);
						System.out.println((i+1)+" "+(j+1));
						return;
					}
				}
			}
		}
		// 승부가 결정되지 않았으면 0 출력
		System.out.println(0);
	}
}
