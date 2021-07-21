package StacknQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ_5076 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		whole: while(true){
			char[] input = br.readLine().toCharArray();

			if(input.length==1 && input[0]=='#') break;

			Stack<String> stack = new Stack<>();

			for(int i=0 ; i<input.length ; i++){
				char now = input[i];
				if(now=='<') {
					StringBuilder sb = new StringBuilder();
					while(true){
						now = input[++i];
						if(now=='>') {
							if(sb.length()==0) {
								//								System.out.println("아무것도 없이 괄호 닫힘");
								bw.write("illegal\n");
								continue whole;
							}
							break;
						}
						if(now=='/'){
							if(sb.length()!=0) {
								if(!sb.toString().equals("br ")){
									//									System.out.println(sb.toString());
									//									System.out.println("/가 중간에 나옴");
									bw.write("illegal\n");
									continue whole;
								}
							}
						}
						if(now=='a' && sb.length()==0){
							while(now!='>'){
								now = input[++i];
								if(now=='"') {
									while(now!='"'){
										now = input[++i];
									}
								}
							}
							stack.push("a");
							break;
						}
						sb.append(now);
					}
					if(sb.length()==0) continue;
					if(sb.charAt(0)=='/') {
						if(stack.isEmpty()) {
							bw.write("illegal\n");
							continue whole;
						}
						else if(sb.toString().substring(1).equals(stack.peek())) stack.pop();
						else {
							//							System.out.println(sb.toString());
							//							System.out.println("stack이랑 안맞음");
							bw.write("illegal\n");
							continue whole;
						}
					}
					else {
						if(!sb.toString().equals("br /")) stack.push(sb.toString());
					}
				}
			}
			if(!stack.isEmpty()) {
				//				System.out.println("stack이 안비어있음");
				bw.write("illegal\n");
				continue whole;
			}
			bw.write("legal\n");
		}

		bw.flush();
	}
}
