package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074_Z {

	public BJ_1074_Z(int n, int r, int c){

	}

	static int count=0;

	private void rec(int n, int row, int col, int r, int c){
		if((row==r && col==c)){
			System.out.println(count);
			return;
		}
		else{
			if(row+n/2>r){
				if(col+n/2>c){
					rec(n/2, row, col, r, c);
				}
				else{
					count += n*n/4;
					rec(n/2, row, col+n/2, r, c);
				}
			}
			else{
				if(col+n/2>c){
					count += n*n/2;
					rec(n/2, row+n/2, col, r, c);
				}
				else{
					count += n*n/4*3;
					rec(n/2, row+n/2, col+n/2, r, c);
				}
			}	
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp = br.readLine();

		int n,r,c;

		n = Integer.parseInt(temp.split(" ")[0]);
		r = Integer.parseInt(temp.split(" ")[1]);
		c = Integer.parseInt(temp.split(" ")[2]);

		BJ_1074_Z z = new BJ_1074_Z((int)Math.pow(2, n), r, c);

		z.rec((int)Math.pow(2, n), 0, 0, r, c);
	}
}
