package Kakao2020;

import java.util.Arrays;

public class K3 {
	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		int[][] key2 = turned(key);
		int[][] key3 = turned(key2);
		int[][] key4 = turned(key3);

		int[][][] keys = {key,key2,key3,key4};

		int zero_num = 0;

		for(int[] ar : lock) {
			for(int i : ar) {
				if(i==0) zero_num++;
			}
		}

		for(int i=0 ; i<4 ; i++) {
			if(canOpen(keys[i], lock, zero_num)) {
				answer = true;
				break;
			}
		}

		return answer;
	}

	private boolean canOpen(int[][] key, int[][] lock, int zero_num) {

		int key_len = key.length;

		boolean wrong = false;
		int count = 0;

		for(int i=1 ; i<=key_len ; i++) {
			for(int j=1 ; j<=key_len ; j++) {
//				System.out.println("\nsize is "+i+" "+j);
				int[][] sub_key = new int[i][j];
				for(int a=0 ; a+i<=key_len ; a++) {
					for(int b=0 ; b+j<=key_len ; b++) {

						for(int x=0 ; x<i ; x++) {
							for(int y=0 ; y<j ; y++) {
								if(key[x+a][y+b]==0) count++;
								sub_key[x][y] = key[x+a][y+b];
							}
						}
						if(zero_num==count) {
//							System.out.println(Arrays.deepToString(sub_key));
							if(check(sub_key, lock)) {
								return true;
							}
						}
						count = 0;
					}
				}
			}
		}

		return false;
	}

	private boolean check(int[][] sub_key, int[][] lock) {
		for(int i=0 ; i<lock.length ; i++) {
			a: for(int j=0 ; j<lock.length ; j++) {
				for(int a=0 ; a<sub_key.length ; a++) {
					for(int b=0 ; b<sub_key.length ; b++) {
						if(sub_key[a][b]!=lock[i+a][j+b]) continue a;
					}
				}
			return true;
			}
		}
		return false;
	}

	private int[][] turned(int[][] key) {
		int len = key.length;
		int[][] ret = new int[len][len];

		for(int i=0 ; i<len ; i++) {
			for(int j=0 ; j<len ; j++) {
				ret[i][j] = key[len-j-1][i];
			}
		}

		return ret;
	}
}
