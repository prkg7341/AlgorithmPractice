package NHN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class N1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		ArrayList<Person> list = new ArrayList<>(numOfAllPlayers-1);

		Person now = new Person('A', false);
		now.count++;

		HashSet<Character> set = new HashSet<>();

		for(int i=0 ; i<namesOfQuickPlayers.length ; i++) {
			set.add(namesOfQuickPlayers[i]);
		}

		for(int i=1 ; i<numOfAllPlayers ; i++) {
			char temp = (char)('A'+i);
			if(set.contains(temp))
				list.add(new Person(temp, true));
			else
				list.add(new Person(temp, false));
		}

		int index = 0;

		for(int i=0 ; i<numOfGames ; i++) {
			int d_index = numOfMovesPerGame[i];

			int next_i = index+d_index;

			while(next_i<0) next_i += list.size();
			next_i %= list.size();

			Person next = list.get(next_i);

			if(!next.fast) {
				list.set(next_i, now);
				now = next;
			}
			now.count++;
			index = next_i;
		}

		for(Person p : list) {
			System.out.println(p.name+" "+p.count);
		}
		System.out.println(now.name+" "+now.count);
	}

	static class Person{
		char name;
		int count;
		boolean fast;
		Person(char name, boolean fast){
			this.name = name;
			this.count = 0;
			this.fast = fast;
		}
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for(int i = 0; i < inputData.numOfGames ; i++){
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}