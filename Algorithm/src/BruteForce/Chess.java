package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Chess {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);

		int[][] ar = new int[row][col-7];

		for(int i=0 ; i<row ; i++){			
			Queue<Byte> queue = new LinkedList<>();	
			int sum = 0;
			input = br.readLine().split("");
			for(int j=0 ; j<col ; j++){
				if((i+j)%2==0){
					if(input[j].compareTo("W")==0){
						sum += 1;
						queue.add((byte) 1);
					}
					else{
						queue.add((byte) 0);
					}
				}
				else{
					if(input[j].compareTo("B")==0){
						sum += 1;
						queue.add((byte) 1);
					}
					else{
						queue.add((byte) 0);
					}
				}

				if(j==7){
					ar[i][j-7] = sum;
				}
				else if(j>7){
					sum -= queue.poll();
					ar[i][j-7] = sum;
				}
			}
		}

		int[] ar2 = new int[(row-7)*(col-7)];
		int index=0;

		for(int i=0 ; i<col-7 ; i++){
			Queue<Integer> queue = new LinkedList<>();
			int sum = 0;
			for(int j=0 ; j<row ; j++){
				sum += ar[j][i];
				queue.add(ar[j][i]);
				if(j==7){
					ar2[index++] = sum;
				}
				else if(j>7){
					sum -= queue.poll();
					ar2[index++] = sum;
				}
			}
		}

		Arrays.sort(ar2);
		int result = Math.min(ar2[0], 64-ar2[ar2.length-1]);
		System.out.println(result);
	}
}
