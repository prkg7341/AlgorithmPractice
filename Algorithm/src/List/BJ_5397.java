package List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_5397 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			Deque<Character> left = new LinkedList<>();
			Deque<Character> right = new LinkedList<>();

			char[] ca = br.readLine().toCharArray();

			for(char c : ca){
				switch(c){
				case '<':
					if(!left.isEmpty()) right.push(left.removeLast());
					break;
				case '>':
					if(!right.isEmpty()) left.offer(right.poll());
					break;
				case '-':
					if(!left.isEmpty()) left.removeLast();
					break;
				default:
					left.offer(c);
					break;
				}
			}
			for(char c : left) bw.write(c);
			for(char c : right) bw.write(c);
			bw.write("\n");
		}

		bw.flush();
	}
}
