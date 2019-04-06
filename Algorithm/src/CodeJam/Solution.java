package CodeJam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] notSosu = new boolean[10001];

		for(int i=2 ; i<10001 ; i++){
			if(!notSosu[i]){
				for(int j=2*i ; j<10001 ; j+=i){
					notSosu[j] = true;
				}
			}
		}

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++){
			sb.append("Case #").append(tt).append(": ");

			PriorityQueue<Integer> list = new PriorityQueue<>(26);

			int l = Integer.parseInt(br.readLine().split(" ")[1]);

			String[] input = br.readLine().split(" ");

			int temp = Integer.parseInt(input[0]);

			int a=-1;
			int next=-1;

			for(int i=2 ; i<10001 ; i++){
				if(!notSosu[i] && temp%i==0){
					a = i;
					next = temp/a;
					list.add(a);
					list.add(next);
					break;
				}
			}

			temp = Integer.parseInt(input[1]);

			boolean check;

			if(temp%a==0){
				next=temp/a;
				check=true;
			}
			else {
				next=temp/next;
				check=false;
			}

			list.add(next);

			for(int i=2 ; i<l ; i++){
				next = Integer.parseInt(input[i])/next;				
				if(!list.contains(next)) list.add(next);
				if(list.size()==26) break;
			}

			int[] ar = new int[26];

			for(int i=0 ; i<26 ; i++){
				ar[i] = list.poll();
			}

			if(check){
				a = Integer.parseInt(input[0])/a;
			}
			sb.append((char)(Arrays.binarySearch(ar, a)+65));
			for(int i=0 ; i<l ; i++){
				a = Integer.parseInt(input[i])/a;
				sb.append((char)(Arrays.binarySearch(ar, a)+65));
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}