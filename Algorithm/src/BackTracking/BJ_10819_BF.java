package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_10819_BF {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>(n);

		String[] input = br.readLine().split(" ");

		for(int i=0 ; i<n ; i++){
			list.add(Integer.parseInt(input[i]));
		}

		int max = 0;

		for(int i=0 ; i<n ; i++){
			int now = list.remove(i);
			max = Math.max(btrk(list, now, 0), max);
			list.add(i, now);
		}

		bw.write(String.valueOf(max));

		bw.flush();
	}

	private static int btrk(ArrayList<Integer> list, int now, int sum) {

		if(list.isEmpty()) return sum;

		int tempMax = 0;

		for(int i=0 ; i<list.size() ; i++){
			int temp = list.remove(i);
			sum += Math.abs(now-temp);
			tempMax = Math.max(tempMax, sum+btrk(list, temp, 0));
			list.add(i, temp);
			sum -= Math.abs(now-temp);
		}

		return sum+tempMax;
	}
}
