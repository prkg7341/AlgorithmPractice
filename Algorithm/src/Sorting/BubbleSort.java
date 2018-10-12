package Sorting;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	
	public static void swap(ArrayList<Integer> al, int a, int b){
		int temp;
		temp = al.get(a);
		al.set(a, al.get(b));
		al.set(b, temp);
	}
	
	public static void main(String[] args) {
		
		
	}
}
