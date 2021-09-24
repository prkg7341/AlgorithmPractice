package Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_17144 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());
		int time = Integer.parseInt(stringTokenizer.nextToken());

		int[][] map = new int[r][c];

		int checkR = 0;

		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				int now = Integer.parseInt(stringTokenizer.nextToken());
				map[i][j] = now;
				if (now == -1)
					checkR = i;
			}
		}

		for (int i = 0; i < time; i++) {
			HashMap<Integer, Integer> tempMap = new HashMap<>();
			for (int k_ = 0; k_ < r; k_++) {
				for (int k = 0; k < c; k++) {
					int spread = map[k_][k] / 5;
					if (spread == 0)
						continue;
					for (int j = 0; j < 4; j++) {
						int newR = k_ + dr[j];
						int newC = k + dc[j];

						if (newR >= 0 && newC >= 0 && newR < r && newC < c && map[newR][newC] >= 0) {
							if (!tempMap.containsKey(newR * 100 + newC))
								tempMap.put(newR * 100 + newC, spread);
							else
								tempMap.put(newR * 100 + newC, tempMap.get(newR * 100 + newC) + spread);
							map[k_][k] -= spread;
						}
					}
				}
			}
			for (int key : tempMap.keySet()) {
				map[key / 100][key % 100] += tempMap.get(key);
			}

			// 순환
			// 1
			for (int j = checkR - 2; j > 0; j--) {
				map[j][0] = map[j - 1][0];
			}
			for (int j = 0; j < c - 1; j++) {
				map[0][j] = map[0][j + 1];
			}
			for (int j = 0; j < checkR - 1; j++) {
				map[j][c - 1] = map[j + 1][c - 1];
			}
			for (int j = c - 1; j > 1; j--) {
				map[checkR - 1][j] = map[checkR - 1][j - 1];
			}
			map[checkR - 1][1] = 0;

			// 2
			for (int j = checkR + 1; j < r - 1; j++) {
				map[j][0] = map[j + 1][0];
			}
			for (int j = 0; j < c - 1; j++) {
				map[r - 1][j] = map[r - 1][j + 1];
			}
			for (int j = r - 1; j > checkR; j--) {
				map[j][c - 1] = map[j - 1][c - 1];
			}
			for (int j = c - 1; j > 1; j--) {
				map[checkR][j] = map[checkR][j - 1];
			}
			map[checkR][1] = 0;
		}

		int sum = 2;

		for (int j = 0; j < r; j++) {
			for (int j2 = 0; j2 < c; j2++) {
				sum += map[j][j2];
			}
		}

		System.out.println(sum);
	}
}
