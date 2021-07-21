package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {

	static int s;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] ar = new char[n][n];

		for(int i=0 ; i<n ; i++){
			ar[i] = br.readLine().toCharArray();
		}

		int maxL = 1;
		char ing = 0;
		int newL = 0;

		for(int i=0 ; i<n ; i++){
			for(int x=0 ; x<n ; x++){
				if(ar[i][x]!=ing){
					newL=1;
					ing = ar[i][x];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			maxL = 1;
			ing = 0;
			newL = 0;
		}

		for(int i=0 ; i<n ; i++){
			for(int x=0 ; x<n ; x++){
				if(ar[x][i]!=ing){
					newL=1;
					ing = ar[x][i];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			maxL = 1;
			ing = 0;
			newL = 0;
		}

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				doit(ar,i,j);
			}
		}
		System.out.print(max);
	}

	static void doit(char[][] ar, int i, int j){
		if(i+1<ar.length && ar[i][j]!=ar[i+1][j]){
			swap(ar,i,j,i+1,j);
			int maxL = 1;
			char ing = 0;
			int newL = 0;
			for(int x=0 ; x<ar.length ; x++){
				if(ar[i][x]!=ing){
					newL=1;
					ing = ar[i][x];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			maxL = 1;
			ing = 0;
			newL = 0;
			for(int x=0 ; x<ar.length ; x++){
				if(ar[i+1][x]!=ing){
					newL=1;
					ing = ar[i+1][x];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			maxL = 1;
			ing = 0;
			newL = 0;
			for(int x=0 ; x<ar.length ; x++){
				if(ar[x][j]!=ing){
					newL=1;
					ing = ar[x][j];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			swap(ar,i,j,i+1,j);
		}
		if(j+1<ar.length && ar[i][j]!=ar[i][j+1]){
			swap(ar,i,j,i,j+1);
			int maxL = 1;
			char ing = 0;
			int newL = 0;
			for(int x=0 ; x<ar.length ; x++){
				if(ar[i][x]!=ing){
					newL=1;
					ing = ar[i][x];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			maxL = 1;
			ing = 0;
			newL = 0;
			for(int x=0 ; x<ar.length ; x++){
				if(ar[x][j+1]!=ing){
					newL=1;
					ing = ar[x][j+1];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			maxL = 1;
			ing = 0;
			newL = 0;
			for(int x=0 ; x<ar.length ; x++){
				if(ar[x][j]!=ing){
					newL=1;
					ing = ar[x][j];
				}
				else{
					newL++;
					if(newL>maxL){
						maxL = newL;
					}
				}
			}
			max = Math.max(max, maxL);
			swap(ar,i,j,i,j+1);
		}
	}

	static void swap(char[][] ar, int i, int j, int newI, int newJ){
		char temp = ar[i][j];
		ar[i][j] = ar[newI][newJ];
		ar[newI][newJ] = temp;
	}
}