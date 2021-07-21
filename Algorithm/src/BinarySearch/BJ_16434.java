package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_16434 {

	static long maxH;
	static long curH;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int rooms = Integer.parseInt(input[0]);
		long atk = Long.parseLong(input[1]);

		long[][] dg = new long[rooms][3];

		for(int i=0 ; i<rooms ; i++){
			input = br.readLine().split(" ");
			for(int j=0 ; j<3 ; j++){
				dg[i][j] = Integer.parseInt(input[j]);
			}
		}

		long left = 1;
		long right = Long.MAX_VALUE-1;

		while(left<=right){
			long mid = (left+right)/2;
			maxH = mid;
			curH = maxH;
			if(fight(dg, 0, atk)){
				right = mid-1;
			}
			else left = mid+1;
		}

		bw.write(String.valueOf(left));

		bw.flush();
	}

	static boolean fight(long[][] dg, int index, long atk){
		if(index==dg.length) {
			return true;
		}

		if(dg[index][0]==1){

			long attack = dg[index][2]/atk;
			if(dg[index][2]%atk!=0) attack++;
			long defense = curH/dg[index][1];
			if(curH%dg[index][1]!=0) defense++;

			if(attack<=defense) {
				curH -= dg[index][1] * (attack-1);
				return fight(dg, index+1, atk);
			}
			else {
				return false;
			}
		}

		else{
			atk += dg[index][1];
			curH += dg[index][2];
			curH = Math.min(curH, maxH);
			return fight(dg, index+1, atk);
		}
	}
}
