package Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Line2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();

		Queue<Character> q1 = new LinkedList<>();
		Queue<Character> q2 = new LinkedList<>(); 

		int num1 = 0;
		int num2 = 0;

		for(int i=0 ; i<input.length ; i++){
			char c = input[i];
			if(c>='A' && c<='Z'){
				num1++;
				q1.add(c);
				while(c>='a' && c<='z'){
					q1.add(c);
					if(i+1<input.length){
						c = input[++i];
					}
				}
			}
			if((int)c>='1' && (int)c<='9'){
				num2++;
				if(c=='1'){
					if(i!=input.length-1 && input[i+1]=='0'){
						q2.add((char) 10);
						i++;
					}
					else{
						q2.add(' ');
					}
				}
				else{
					q2.add(c);
				}
			}
		}
		if(num1!=num2){
			System.out.print("error");
		}
		else{
			while(!q1.isEmpty()){
				sb.append(q1.poll());
				char temp = q2.poll();
				if(temp!=' ')
					sb.append(temp);
			}
			System.out.print(sb.toString());
		}
	}
}
