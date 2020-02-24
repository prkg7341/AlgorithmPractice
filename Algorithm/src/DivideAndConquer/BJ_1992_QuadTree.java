package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_QuadTree {

	StringBuilder sb = new StringBuilder();	

	public BJ_1992_QuadTree(int[][] ar){
		int length = ar.length;
		divide(ar, 0, length-1, 0, length-1);
		System.out.println(sb);
	}

	private void divide(int ar[][], int x1, int x2, int y1, int y2) {
		int midX= (x1+x2)/2;
		int midY= (y1+y2)/2;
		if(x1==x2){
			if(ar[x1][y1]==1) sb.append(1);
			else sb.append(0);
		}
		else{
			if(compare(ar, x1, x2, y1, y2)){
				if(ar[x1][y1]==1) sb.append(1);
				else sb.append(0);
			}
			else{
				sb.append("(");
				divide(ar, x1, midX, y1, midY);
				divide(ar, midX+1, x2, y1, midY);
				divide(ar, x1, midX, midY+1, y2);
				divide(ar, midX+1, x2, midY+1, y2);	
				sb.append(")");
			}
		}
	}

	private boolean compare(int[][] ar, int x1, int x2, int y1, int y2) {
		boolean same = false;
		int count=(x2-x1)*(y2-y1);
		for(int i=y1 ; i<y2 ; i++){
			for(int j=x1 ; j<x2 ; j++){
				if(ar[j][i]==ar[j+1][i+1] && ar[j][i]==ar[j][i+1] && ar[j][i]==ar[j+1][i]){
					count--;
				}
			}
		}
		if(count==0) same=true;
		return same;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;

		int n;		
		n = Integer.parseInt(br.readLine().toString()); 

		int[][] ar = new int[n][n];

		for(int i=0 ; i<ar.length ; i++){
			s = br.readLine();

			for(int j=0 ; j<ar.length ; j++){
				ar[j][i] = s.charAt(j)-48;
			}
		}

		new BJ_1992_QuadTree(ar);

		br.close();
	}
}
