package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1780_DividePaper {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[n][n];
		int start = 0;
		int end = n-1;
		int[] array = new int[3];
		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++){
				paper[i][j] = Integer.parseInt(input[j]);
			}
		}
		devide(paper, start, start, end, end, array);
		print(array);
	}

	static void devide(int[][] paper, int startX, int startY, int endX, int endY, int[] array) {
		int now = paper[startX][startY];
		boolean same = true;

		ar:
			for(int i=startX ; i<=endX ; i++){
				for(int j=startY ; j<=endY ; j++){				
					if(paper[i][j]!=now){
						same = false;
						break ar;
					}
				}
			}

		if(same) array[now+1]++;

		else{
			int x1 = (2*(startX+1)+(endX+1))/3;
			int x2 = ((startX+1)+2*(endX+1))/3;
			int y1 = (2*(startY+1)+(endY+1))/3;
			int y2 = ((startY+1)+2*(endY+1))/3;
			devide(paper, startX, 	startY, x1-1, y1-1, array);
			devide(paper, startX, 	y1, 	x1-1, y2-1, array);
			devide(paper, startX, 	y2, 	x1-1, endY, array);
			devide(paper, x1, 		startY, x2-1, y1-1, array);
			devide(paper, x1, 		y1,		x2-1, y2-1, array);
			devide(paper, x1, 		y2, 	x2-1, endY, array);
			devide(paper, x2, 		startY, endX, y1-1, array);
			devide(paper, x2, 		y1, 	endX, y2-1, array);
			devide(paper, x2, 		y2, 	endX, endY, array);
		}
	}

	static void print(int[] count){
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}
}
