package DivideAndConquer;
import java.util.Scanner;

public class Quick {
	
	public static void quickSort(int[] ar, int left, int right){
		if(left<right){
			int mid, pivot, temp, left2, right2;

			left2=left;
			right2=right;
			mid=(left+right)/2;
			pivot = ar[mid];

			temp = ar[mid];
			ar[mid] = ar[left];
			ar[left] = temp;

			left+=1;

			while(true){
				while(ar[left]<=pivot){
					left++;
				}
				while(ar[right]>pivot){
					right--;
				}
				if(left>right){
					break;
				}

				temp = ar[right];
				ar[right] = ar[left];
				ar[left] = temp;
			}

			temp = ar[right];
			ar[right] = ar[left2];
			ar[left2] = temp;

			quickSort(ar, left2, right-1);
			quickSort(ar, right+1, right2);
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for(int i=0 ; i < ar.length ; i++){
			ar[i] = sc.nextInt();
		}
		sc.close();

		quickSort(ar, 0, n-1);

		for(int i=0; i<ar.length ; i++)
			System.out.println(ar[i]);
	}

}
