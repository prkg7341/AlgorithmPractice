import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		String temp;
		
		for(int i=0 ; i<n ; i++){
			int m = Integer.parseInt(br.readLine());
			temp = br.readLine();
			int[] ar = new int[m];
			for(int j=0 ; j<m ; j++){
				ar[j] = Integer.parseInt(temp.split(" ")[j]);
			}
			
			sb.append(dnc(ar,0,ar.length-1)+"\n");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int dnc(int[] ar, int left, int right) {
		
		int mid = (left+right)/2;
		int max;
		
		if(right==left){
			return ar[right];
		}

		else if(right-left==1){
			max = Math.max(Math.max(ar[left], ar[right]), ar[left]+ar[right]);
		}
		else{
			max = Math.max(Math.max(dnc(ar,left,mid), dnc(ar,mid+1,right)), getCenteredMaxLength(ar, left, right));			
		}
		
		return max;		
	}

	private static int getCenteredMaxLength(int[] ar, int left, int right) {
		
		int mid = (left+right)/2;

		int tempMax = Integer.MIN_VALUE;
		
		int leftMax = 0;
		int rightMax = 0;
		
		for(int i=mid ; i>=left ; i--){
			leftMax += ar[i];
			tempMax = Math.max(tempMax, leftMax);
		}
		
		leftMax = tempMax;
		tempMax = Integer.MIN_VALUE;
		
		for(int i=mid+1 ; i<=right ; i++){
			rightMax += ar[i];
			tempMax = Math.max(tempMax, rightMax);
		}
		rightMax = tempMax;
		
		return leftMax + rightMax;
	}

}
