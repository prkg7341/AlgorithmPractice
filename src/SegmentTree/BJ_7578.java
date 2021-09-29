package SegmentTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 기본 세그먼트트리 문제에서 update해주는 value만 1로 고정시켜주면 되는 문제
 * 
 * HashMap을 활용해 각 번호에 index를 저장해두고, 
 * 순서가 바뀐 입력이 들어오면 HashMap에 저장된 index에 따라 값을 1로 update하고
 * 해당 index보다 오른쪽에 있는 1의 개수 (index+1 부터 n-1 의 sum)를 세서 return
 * 
 * #주의할점: 출력하는 값이 int 범위를 넘어가기 때문에 long 타입을 써야한다!!
 * 
 */
public class BJ_7578 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] segtree = new int[4 * n];
		HashMap<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			map.put(Integer.parseInt(st.nextToken()), i);
		}

		st = new StringTokenizer(br.readLine());

		long count = 0;

		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			int index = map.get(now);

			update(segtree, 1, 1, index, 0, n - 1);
			count += sum(segtree, index + 1, n - 1, 1, 0, n - 1);
		}

		System.out.println(count);
	}

	private static int update(int[] segtree, int value, int node, int index, int left, int right) {
		int mid = (left + right) / 2;
		int dif;

		if (left >= right) {
			dif = value - segtree[node];
		} else if (mid >= index) {
			dif = update(segtree, value, node * 2, index, left, mid);
		} else {
			dif = update(segtree, value, node * 2 + 1, index, mid + 1, right);
		}

		segtree[node] += dif;
		return dif;
	}

	private static long sum(int[] segtree, int from, int to, int node, int leftNode, int rightNode) {
		if (leftNode >= from && rightNode <= to)
			return segtree[node];
		if (rightNode < from || leftNode > to)
			return 0;
		int mid = (leftNode + rightNode) / 2;
		return sum(segtree, from, to, node * 2, leftNode, mid)
				+ sum(segtree, from, to, node * 2 + 1, mid + 1, rightNode);
	}
}