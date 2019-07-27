package UCPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);

		char[][] ar = new char[x][y];

		for(int i=0 ; i<x ; i++){
			String inputt = br.readLine();
			for(int j=0 ; j<y ; j++){
				char now = inputt.charAt(j);
				switch(now){
				case '.':
					now = '.';
					break;
				case 'O':
					now = 'O';					
					break;
				case '-':
					now = '|';					
					break;
				case '|':
					now = '-';					
					break;
				case '/':
					now = '\\';					
					break;
				case '\\':
					now = '/';					
					break;
				case '^':
					now = '<';					
					break;
				case '<':
					now = 'v';					
					break;
				case 'v':
					now = '>';					
					break;
				case '>':
					now = '^';					
					break;
				}
				ar[i][j] = now;
			}			
		}	

		for(int i=y-1 ; i>=0 ; i--){
			for(int j=0 ; j<x ; j++){
				sb.append(ar[j][i]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
