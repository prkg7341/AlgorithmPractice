package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_21610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 8방향
		int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
		int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] ar = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구름의 위치를 저장하는 HashSet
		HashSet<Integer> cloudSet = new HashSet<>();
		// 초기값 입력
		cloudSet.add((n - 1) * n);
		cloudSet.add((n - 1) * n + 1);
		cloudSet.add((n - 2) * n);
		cloudSet.add((n - 2) * n + 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			// 다음 턴의 구름의 위치를 저장할 HashSet
			HashSet<Integer> newCloudSet = new HashSet<>();
			// 5번 조건에서 구름이 사라진 칸인지 체크하기 위한 배열
			boolean[][] visit = new boolean[n][n];

			// 1. 모든 구름이 di 방향으로 si칸 이동한다.
			// 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
			for (int position : cloudSet) {
				int r = position / n;
				int c = position % n;

				int nr = r + dr[d] * s;
				int nc = c + dc[d] * s;

				nr %= n;
				nc %= n;

				if (nr < 0)
					nr += n;
				if (nc < 0)
					nc += n;

				// 위치를 찾아 +1, visit 체크
				ar[nr][nc]++;
				visit[nr][nc] = true;
			}

			// 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
			for (int position : cloudSet) {
				int r = position / n;
				int c = position % n;

				int nr = r + dr[d] * s;
				int nc = c + dc[d] * s;

				nr %= n;
				nc %= n;

				if (nr < 0)
					nr += n;
				if (nc < 0)
					nc += n;

				// 대각선 방향에 물이 있는 바구니 수만큼 증가
				for (int j = 1; j < 8; j += 2) {
					int nnr = nr + dr[j];
					int nnc = nc + dc[j];

					if (nnr >= 0 && nnr < n && nnc >= 0 && nnc < n) {
						if (ar[nnr][nnc] > 0)
							ar[nr][nc]++;
					}
				}
			}

			// 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 
			//    이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
			for (int j = 0; j < n * n; j++) {
				if (!visit[j / n][j % n] && ar[j / n][j % n] >= 2) {
					newCloudSet.add(j);
					ar[j / n][j % n] -= 2;
				}
			}

			cloudSet = newCloudSet;
		}

		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += ar[i][j];
			}
		}

		System.out.println(sum);
	}
}