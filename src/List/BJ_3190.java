package List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_3190 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		int n = Integer.parseInt(br.readLine());

		// 1�̸� ��, -1�̸� ���
		int[][] table = new int[n][n];

		int apples = Integer.parseInt(br.readLine());

		for(int i=0 ; i<apples ; i++){
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[1])-1;
			int y = Integer.parseInt(input[0])-1;
			table[y][x] = -1;
		}
		// D�̸� ++, L�̸� --
		int direction = 0;
		Deque<Position> snake = new LinkedList<>();
		snake.offer(new Position(0, 0));

		int num = Integer.parseInt(br.readLine());

		int second = 0;

		for(int i=0 ; i<num ; i++){
			String[] input = br.readLine().split(" ");
			int sec = Integer.parseInt(input[0]);
			while(second<sec){
				//				System.out.println(second+"��");
				Position head = snake.peekFirst();
				//				System.out.println(head.x+" "+head.y);
				try{
					int newX = head.x+dx[direction];
					int newY = head.y+dy[direction];
					//					System.out.println(newY+" "+newX+" �� ������");
					snake.push(new Position(newX, newY));
					if(table[newY][newX]==0) {
						Position tail = snake.removeLast();
						table[tail.y][tail.x] = 0;
					}
					else if(table[newY][newX]==-1) table[newY][newX] = 0;
					else {
						//						System.out.println("���̶� ���� 1");
						bw.write(String.valueOf(++second));
						bw.flush();
						return;
					}
					table[newY][newX] = 1;
				} catch(Exception e){
					//					System.out.println("������ ���� 1");
					bw.write(String.valueOf(++second));
					bw.flush();
					return;
				}
				second++;
			}
			if(input[1].equals("D")) {
				direction = (direction+1)%4;
				//				System.out.println(direction+"�� ���� �ٲ�");
			}
			else direction = (direction+3)%4;
		}

		while(true){
			//			System.out.println(second+"��");
			Position head = snake.peekFirst();
			//			System.out.println(head.x+" "+head.y);
			try{
				int newX = head.x+dx[direction];
				int newY = head.y+dy[direction];
				//				System.out.println(newY+" "+newX+" �� ������");
				snake.push(new Position(newX, newY));
				if(table[newY][newX]==0) {
					Position tail = snake.removeLast();
					table[tail.y][tail.x] = 0;
				}
				else if(table[newY][newX]==-1) table[newY][newX] = 0;
				else {
					//					System.out.println("���̶� ���� 2");
					bw.write(String.valueOf(++second));
					bw.flush();
					return;
				}
				table[newY][newX] = 1;
			} catch(Exception e){
				//				System.out.println("������ ���� 2");
				bw.write(String.valueOf(++second));
				bw.flush();
				return;
			}
			second++;
		}
	}

	static class Position{
		int x;
		int y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
