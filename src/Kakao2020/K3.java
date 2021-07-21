package Kakao2020;

public class K3 {
	public boolean solution(int[][] key, int[][] lock) {
		for(int i=0 ; i<4 ; i++) {
			if(compare(key, lock)) return true;
			key = turn(key);
		}

		return false;
	}

	private int[][] turn(int[][] ar){
		int[][] ret = new int[ar.length][ar[0].length];

		for(int i=0 ; i<ret.length ; i++) {
			for(int j=0 ; j<ret[0].length ; j++) {
				ret[i][j] = ar[ar.length-j-1][i];
			}
		}

		return ret;
	}

	private boolean compare(int[][] key_, int[][] lock) {
		int[][] key = new int[key_.length+2*lock.length-2][key_.length+2*lock.length-2];

		for(int i=0 ; i<key_.length ; i++) {
			for(int j=0 ; j<key_.length ; j++) {
				key[lock.length-1+i][lock.length-1+j] = key_[i][j];
			}
		}

		for(int i=0 ; i<=key.length-lock.length ; i++) {
			loop:for(int j=0 ; j<=key.length-lock.length ; j++) {
				for(int x=0 ; x<lock.length ; x++) {
					for(int y=0 ; y<lock.length ; y++) {
						if(key[i+x][j+y]+lock[x][y]!=1) {
							continue loop;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
}
