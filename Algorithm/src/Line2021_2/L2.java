package Line2021_2;

import java.util.HashMap;
import java.util.HashSet;

public class L2 {
	public boolean[] solution(String program, String[] flag_rules, String[] commands) {
		// 리턴할 boolean 배열
		boolean[] answer = new boolean[commands.length];

		// flag rule을 저장하기 위한 해쉬맵
		HashMap<String, String> rule = new HashMap<>();

		// 배열로 주어진  flag rule들을 각 해쉬맵에 저장
		for(int i=0 ; i<flag_rules.length ; i++) {
			String[] input = flag_rules[i].split(" ");
			rule.put(input[0], input[1]);
		}

		// 각 커맨드를 참조하여 처리
		for(int i=0 ; i<commands.length ; i++) {

			// 리턴값에 들어갈 boolean 변수를 true로 초기화하여 선언
			boolean ret = true;

			// 각 커맨드를 공백을 기준으로 끊어서 저장
			String[] input = commands[i].split(" ");

			// 프로그램이름이 다른지 체크
			String pro = input[0];
			if(!pro.equals(program)) {
				answer[i] = false;System.out.println("프로그램 이름이 다릅니다!");
				continue;
			}			

			// 각 flag가 여러번 나오는지 체크하기 위한 해쉬셋
			HashSet<String> set = new HashSet<>();
			for(String key : rule.keySet()) set.add(key);
			
			// 공백 기준으로 끊은 커맨드를 참조하면서 오류가 있는지 확인하는 반복문
			loop: for(int j=1 ; j<input.length ; j++) {
				String flag_rule = input[j];	
				System.out.println("flag_rule: "+flag_rule);
				
				// 해당 flag가 rule에 있는지 확인
				if(rule.containsKey(flag_rule)) {
					if(rule.get(flag_rule).equals("STRING")) {
						// flag_argument_type 변수가 없으면 오류 출력
						if(j==input.length-1) {
							ret = false;System.out.println("STRING 변수가 없습니다!");
							break;
						}
						// STRING에 적합한 변수를 받는지 확인
						String next = input[j+1];
						for(int k=0 ; k<next.length() ; k++) {
							if(!((next.charAt(k)>='A' && next.charAt(k)<='Z') || (next.charAt(k)>='a' && next.charAt(k)<='z'))) {
								ret = false;System.out.println(next+" 는 적합한 STRING 변수가 아닙니다!");
								break loop;
							}
						}
						j++;
					}
					else if(rule.get(flag_rule).equals("NUMBER")) {
						// NUMBER에 적합한 변수를 받는지 확인
						try{
							Integer.parseInt(input[j+1]);
						}catch(Exception e) {
							ret = false;System.out.println(input[j+1]+" 는 적합한 NUMBER 변수가 아닙니다!");
							break;
						}
						j++;
					}
					else if(rule.get(flag_rule).equals("NUMBERS")) {
						// NUMBER에 적합한 변수를 받는지 확인
						try{
							Integer.parseInt(input[j+1]);
						}catch(Exception e) {
							ret = false;System.out.println(input[j+1]+" 는 적합한 NUMBER 변수가 아닙니다!");
							break loop;
						}
						j++;

						// 0개 이상의 NUMBER 변수를 받기 위한 반복문
						while(true) {
							try{
								Integer.parseInt(input[j+1]);
							}catch(Exception e) {
								break;
							}
							j++;
						}

					}
					else if(rule.get(flag_rule).equals("STRINGS")) {
						if(j==input.length-1) {
							ret = false;System.out.println("STRING 변수가 없습니다!");
							break;
						}
						// STRING에 적합한 변수를 받는지 확인
						String next = input[j+1];
						for(int k=0 ; k<next.length() ; k++) {
							if(!((next.charAt(k)>='A' && next.charAt(k)<='Z') || (next.charAt(k)>='a' && next.charAt(k)<='z'))) {
								ret = false;System.out.println(next+" 는 적합한 STRING 변수가 아닙니다!");
								break loop;
							}
						}
						j++;
						
						// 0개 이상의 STRING 변수를 받기 위한 반복문
						while(true) {
							if(j==input.length-1) {
								break;
							}
							next = input[j+1];
							for(int k=0 ; k<next.length() ; k++) {
								if(!((next.charAt(k)>='A' && next.charAt(k)<='Z') || (next.charAt(k)>='a' && next.charAt(k)<='z'))) {									
									break;
								}
							}
							j++;
						}
					}
					// 마지막이 아니거나 다음에 flag가 나오지 않을때 flag argument를 받지 않는 flag가 나오면 오류 출력
					else {
						if(j!=input.length-1 && input[j+1].charAt(0)!='-') {
							ret = false;System.out.println("flag argument를 가질 수 없는 flag입니다!");
							break;
						}
					}

					// 한 flag가 두번이상 쓰이면 오류 출력
					if(!set.remove(flag_rule)) {
						ret = false;System.out.println("한 flag는 한번의 command에 한번만 사용 가능합니다!");
						break;
					}
				}
				// 해당 flag가 rule에 없으면 오류 출력
				else {
					ret = false;ret = false;System.out.println("해당 flag rule이 없습니다");
					break;
				}
			}
			answer[i] = ret;
		}       

		return answer;
	}
}
