package Kakao2019;

import java.util.ArrayList;

public class OpenChatting_my {
	
	public static void main(String[] args){
		OpenChatting_my s = new OpenChatting_my();
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		for(String st : s.solution(input)){
			System.out.println(st);
		}
	}

	public String[] solution(String[] record) {
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Messages> messages = new ArrayList<>();
		for(String m : record){
			String[] temp = m.split(" ");
			String message = temp[0];
			String uid = temp[1];
			switch(message){
			case "Enter":{
				String name = temp[2];
				if(users.size()==0){
					users.add(new User(uid, name));
				}
				else{
					int[] ret = biSearch(users, uid, 0, users.size()-1);
					int index = ret[1];
					// 기존에 없으면 새로 생성
					if(ret[0]==-1){
						users.add(index, new User(uid, name));
					}
					else{
						users.get(index).name = name;
					}
				}
				messages.add(new Messages(uid, true));
				break;
			}

			case "Leave":{
				messages.add(new Messages(uid, false));
				break;
			}
			case "Change":{
				String name = temp[2];
				int[] ret = biSearch(users, uid, 0, users.size()-1);
				int index = ret[1];
				users.get(index).name = name;
				break;
			}
			}
		}

		String[] answer = new String[messages.size()];
		int i = 0;
		for(Messages m : messages){
			String ans = users.get(biSearch(users, m.id, 0, users.size()-1)[1]).name + "님이 ";

			if(m.inout){
				// in
				ans += "들어왔습니다.";
			}
			else{
				//out
				ans += "나갔습니다.";
			}
			answer[i] = ans;
			i++;
		}
		return answer;
	}

	private static int[] biSearch(ArrayList<User> users, String uid, int left, int right) {

		if(left>right) {
			return new int[] {-1, left};
		}

		int mid = (left+right)/2;

		String mid_id = users.get(mid).id;

		if(mid_id.compareTo(uid)==1) {
			return biSearch(users, uid, left, mid-1);
		}
		else if(mid_id.compareTo(uid)==0) {
			return new int[] {0, mid};
		}
		else {
			return biSearch(users, uid, mid+1, right);
		}
	}

	static class Messages{
		String id;
		boolean inout; // true면 in, false면 out
		Messages(String id, boolean inout){
			this.id = id;
			this.inout = inout;
		}
	}

	static class User{
		String id;
		String name;
		User(String id, String name){
			this.id = id;
			this.name = name;
		}
	}
}
