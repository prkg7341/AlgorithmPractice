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
 * ���Ѽ���
 * �Ϲ����� DP�� Ȱ���ؼ� Ǯ�� �޸� or �ð� �ʰ��� ���� �ȴ�.
 * ������ ����ϴ� ���� ������ ���� ������ �ߺ��Ǳ� ������
 * map�� ���� �����ϰ�, �������� ������ �ؼ� �ð��� ���δ�.
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
