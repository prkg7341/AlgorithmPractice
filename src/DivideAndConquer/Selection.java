package DivideAndConquer;
import java.util.Scanner;

public class Selection {

	public static void selection(int[] ar, int left, int right, int k){

		int mid, pivot, s, left2, right2, temp;
		mid = (left+right)/2;
		pivot = ar[mid];
		right2 = right;
		left2 = left;

		temp = ar[mid];
		ar[mid] = ar[left];
		ar[left] = temp;

		left++;

		while(true){
			while(ar[left]<=pivot){
				left++;
				if(left==right){
					break;
				}
			}
			while(ar[right]>pivot){
				right--;
			}
			if(left<=right){
				break;
			}
			System.out.println(left+" "+right);
			temp = ar[left];
			ar[left] = ar[right];
			ar[right] = temp;
		}
		
		temp = ar[left2];
		ar[left2] = ar[right];
		ar[right] = temp;

		for(int i=0; i<ar.length;i++){
			System.out.print(ar[i]);			
		}
		System.out.println();

		s = right - left +1;

		if(k<=s){
			selection(ar, left2, right, k);
		}
		else if(k == right+1){
			System.out.println(ar[right+1]);
		}
		else {
			selection(ar, right+1, right2, k-s-1);
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] ar = new int[n];
		for(int i=0 ; i < ar.length ; i++){
			ar[i] = sc.nextInt();
		}
		sc.close();

		selection(ar, 0, n-1, k);

	}
}
