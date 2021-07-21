package Kakao_WinterInternship;

import java.util.HashMap;

public class K4 {
	public long[] solution(long k, long[] room_number) {

		long[] answer = new long[room_number.length];
		int index = 0;

		HashMap<Long, Long> rooms = new HashMap<>();

		for(int i=0 ; i<room_number.length ; i++){
			long num = room_number[i];
			if(rooms.containsKey(num)){
				long temp = rec(rooms,num);
				rooms.put(temp, temp+1);
				answer[index++] = temp;
			}
			else{
				rooms.put(num, num+1);
				answer[index++] = num;
			}
		}
		return answer;
	}

	private long rec(HashMap<Long, Long> rooms, long num) {

		if(rooms.containsKey(num)){
			if(rooms.get(num)==0) {
				rooms.replace(num, num+1);
				return num+1;
			}
			else{
				long temp = rec(rooms, rooms.get(num));
				rooms.replace(num, temp);
				return temp;
			}
		}
		else{
			rooms.put(num, num+1);
			return num;
		}
	}
}
