package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z {

	public Z(int n, int r, int c){

	}

	static int count=0;

	private void rec(int n, int row, int col, int r, int c){
		if((row==r && col==c)){
			System.out.println(count);
			return;
		}
		else{
			if(n!=1){
				rec(n/2, row, col, r, c);
				rec(n/2, row, col+n/2, r, c);
				rec(n/2, row+n/2, col, r, c);
				rec(n/2, row+n/2, col+n/2, r, c);
			}
			else{
				count++;
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

		Z z = new Z((int)Math.pow(2, n), r, c);

		z.rec((int)Math.pow(2, n), 0, 0, r, c);
	}
}
