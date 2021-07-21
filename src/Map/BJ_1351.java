package Map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * 
 * @author prkg7
 * 
 * 무한수열
 * 일반적인 DP를 활용해서 풀면 메모리 or 시간 초과가 나게 된다.
 * 실제로 사용하는 값의 개수는 적고 여러번 중복되기 때문에
 * map에 값을 저장하고, 없을때만 연산을 해서 시간을 줄인다.
 *
 */
public class BJ_1351 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		long n = Long.parseLong(input[0]);
		int p = Integer.parseInt(input[1]);
		int q = Integer.parseInt(input[2]);

		HashMap<Long, Long> map = new HashMap<>();

		map.put(0L, 1L);

		long result;

		if(n>0)
			result = req(map, n/p, p, q) + req(map, n/q, p, q);
		else
			result = 1;
		bw.write(String.valueOf(result));
		bw.flush();
	}

	private static long req(HashMap<Long, Long> map, long n, int p, int q) {

		if(!map.containsKey(n)){
			map.put(n, req(map, n/p, p, q) + req(map, n/q, p, q));
		}
		return map.get(n);
	}
}
