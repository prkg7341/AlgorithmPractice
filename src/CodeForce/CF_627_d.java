package CodeForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CF_627_d {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long count = 0;

		String[] input = br.readLine().split(" ");

		String[] input2 = br.readLine().split(" ");

		long[] ar = new long[n];

		long countP = 0;
		long countM = 0;

		for(int i=0 ; i<n ; i++) {
			int temp = Integer.parseInt(input[i])-Integer.parseInt(input2[i]);
			ar[i] = temp;
			if(temp>0) countP++;
			else countM++;
		}

		Arrays.parallelSort(ar);

		long[] arP = new long[(int) countP];
		long[] arM = new long[(int) countM];

		for(int i=0 ; i<countM ; i++) {
			arM[i] = ar[i];
		}

		for(int i=(int) countM ; i<ar.length ; i++) {
			arP[(int) (i-countM)] = ar[i];
		}

		count += countP*(countP-1L)/2L;

		int index = 0;
		for(int i=(int) (countM-1) ; i>=0 ; i--) {
			for(int j=index ; j<countP ; j++) {
				if(arM[i]+arP[j]>0) {
					long temp = countP-(long)j;
					count += temp;
					index = j;
					break;
				}
			}
		}
		bw.write(count+"\n");
		bw.flush();
	}
}
