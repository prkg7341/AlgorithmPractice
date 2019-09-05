package Kakao2019;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args){
		Solution s = new Solution();
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		for(String st : s.solution(input)){
			System.out.println(st);
		}
	}

	public String[] solution(String[] record) {
		HashMap<String, String> users = new HashMap<>();
		int size = 0;
		for(String m : record){
			String[] temp = m.split(" ");
			String message = temp[0];
			String uid = temp[1];
			String name;
			switch(message){
			case "Enter":
				size++;

			case "Change":
				name = temp[2];
				users.put(uid, name);
				break;

			case "Leave":
				size++;
				break;
			}
		}

		String[] answer = new String[size];
		int i = 0;
		for(String m : record){
			String[] temp = m.split(" ");
			String message = temp[0];
			String uid = temp[1];
			if(message.contains("Change")){
				continue;
			}
			String ans = users.get(uid) + "님이 ";

			if(message.contains("Enter")){
				ans += "들어왔습니다.";
			}
			else{
				ans += "나갔습니다.";
			}
			answer[i] = ans;
			i++;
		}
		return answer;
	}
}
