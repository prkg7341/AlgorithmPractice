package NHN;

import java.util.Scanner;
import java.util.Stack;

public class N3 {
	private static void solution(int numOfOrder, String[] orderArr) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		for(int i=0 ; i<numOfOrder ; i++) {
			char[] now = orderArr[i].toCharArray();

			StringBuilder sb = new StringBuilder();

			Stack<Info> st = new Stack<>();

			for(int j=0 ; j<now.length ; j++) {
				if(now[j]=='(') {					
					sb.deleteCharAt(sb.length()-1);					
					st.add(new Info(sb, j));
					sb = new StringBuilder();
				}

				else if(now[j]==')') {

					Info info = st.pop();
					char before = now[info.index-1];
					StringBuilder whole = info.sb;

					if(before>='A' && before<='Z') {
						for(int k=0 ; k<sb.length() ; k++) {
							whole.append(before).append(sb.charAt(k));
						}
					}
					else {
						for(int k=0 ; k<(int)(before-'0') ; k++) whole.append(sb);
					}

					sb = whole;
				}

				else if(now[j]>='A' && now[j]<='Z') {
					if(j>0 && now[j-1]>='1' && now[j-1]<='9') {
						sb.deleteCharAt(sb.length()-1);
						for(int k=0 ; k<(int)(now[j-1]-'0') ; k++) sb.append(now[j]);
					}
					else {
						sb.append(now[j]);
					}
				}				

				else {
					sb.append(now[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}

	static class Info{
		StringBuilder sb;
		int index;
		Info(StringBuilder sb, int index){
			this.sb = sb;
			this.index = index;
		}
	}

	private static class InputData {
		int numOfOrder;
		String[] orderArr;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.orderArr = new String[inputData.numOfOrder];
			for (int i = 0; i < inputData.numOfOrder; i++) {
				inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfOrder, inputData.orderArr);
	}
}