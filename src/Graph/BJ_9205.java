package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BJ_9205 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		loop: for (int tt = 1; tt <= t; tt++) {
			int con = Integer.parseInt(br.readLine());

			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			ConcurrentLinkedQueue<Position> list = new ConcurrentLinkedQueue<>();

			int startR = Integer.parseInt(stringTokenizer.nextToken()) + 32768;
			int startC = Integer.parseInt(stringTokenizer.nextToken()) + 32768;

			for (int i = 0; i < con; i++) {
				stringTokenizer = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(stringTokenizer.nextToken()) + 32768;
				int c = Integer.parseInt(stringTokenizer.nextToken()) + 32768;

				list.add(new Position(r, c));
			}

			stringTokenizer = new StringTokenizer(br.readLine());

			int endR = Integer.parseInt(stringTokenizer.nextToken()) + 32768;
			int endC = Integer.parseInt(stringTokenizer.nextToken()) + 32768;

			list.add(new Position(endR, endC));

			Queue<Position> q = new LinkedList<>();

			q.add(new Position(startR, startC));

			while (!q.isEmpty()) {
				Position now = q.poll();

				for (Position position : list) {
					if (getDistance(now, position) <= 1000) {
						if (position.r == endR && position.c == endC) {
							System.out.println("happy");
							continue loop;
						}
						q.add(position);
						list.remove(position);
					}
				}
			}
			System.out.println("sad");
		}
	}

	private static int getDistance(Position p1, Position p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}

	static class Position {
		int r, c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
