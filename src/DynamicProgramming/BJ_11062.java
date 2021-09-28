package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 처음 접근:
 * 나올 수 있는 점수차를 최소화한다.
 * => 매턴 최선의 플레이를 하지 않게 되는 경우가 발생
 * 
 * 풀이:
 * 매턴 최선의 플레이를 한다
 * 나의 턴에는 left, right 중 max, 
 * 상대 턴에는 left, right 중 min 값을 return
 */
public class BJ_11062 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= t; tt++) {
			int n = Integer.parseInt(br.readLine());
			int[] ar = new int[n];

			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(stringTokenizer.nextToken());
			}

			int[][] visit = new int[n][n];

			int left = 0, right = n - 1;

			System.out.println(game(ar, visit, left, right, 0));
		}
	}

	private static int game(int[] ar, int[][] visit, int left, int right, int depth) {
		// 카드가 한장도 안남으면 끝
		if (left > right) {
			return 0;
		}
		// 이미 남은 카드로 나올 결과를 알고 있으면 해당 값 리턴
		if (visit[left][right] > 0)
			return visit[left][right];

		// 나의 턴에는 최대값
		if (depth % 2 == 0) {
			return visit[left][right] = Math.max(ar[left] + game(ar, visit, left + 1, right, depth + 1),
					ar[right] + game(ar, visit, left, right - 1, depth + 1));
		}
		// 상대 턴에는 상대도 최선의 플레이를 하기 때문에 최소값
		else {
			return visit[left][right] = Math.min(game(ar, visit, left + 1, right, depth + 1),
					game(ar, visit, left, right - 1, depth + 1));
		}
	}
}
