package Kakao_WinterInternship;

import java.util.ArrayList;
import java.util.Arrays;

public class K3 {
	static int aaa = 0;
	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;

		Arrays.sort(banned_id);

		ArrayList<String> users = new ArrayList<>();

		for(int i=0 ; i<user_id.length ; i++){
			users.add(user_id[i]);
		}

		bt(users, banned_id, 0);

		for(int i=0 ; i<banned_id.length ; i++){
			String now = banned_id[i];
			int count = 1;
			while(i+1<banned_id.length && now.compareTo(banned_id[i+1])==0){
				i++;
				count++;
			}
			aaa /= count;
		}

		answer = aaa;

		return answer;
	}

	private void bt(ArrayList<String> users, String[] banned_id, int index) {

		if(index==banned_id.length) {
			aaa++;
			return;
		}

		String ban = banned_id[index];

		for(int j=0 ; j<users.size() ; j++){
			String user = users.get(j);
			if(same(user, ban)){
				String temp = users.remove(j);
				bt(users, banned_id, index+1);
				users.add(j, temp);
			}
		}
	}

	private boolean same(String user, String ban) {

		if(user.length()==ban.length()){
			for(int i=0 ; i<user.length() ; i++){
				if(ban.charAt(i)!='*')
					if(user.charAt(i)!=ban.charAt(i)) return false;
			}
			return true;
		}

		return false;
	}
}
