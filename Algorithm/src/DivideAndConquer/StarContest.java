package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarContest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().toString()); //�������� ��
		int[] ar = new int[n]; //��¿�
		String line = null;
		int count = n; //��� index0
		for(int i=0 ; i<n ; i++){ //�������ŭ �ݺ�
			line = br.readLine(); //n��° ����� ���� ����
			//int m = Integer.parseInt(line.split(" "));
			if(line.length()==1){ //�̱�� ���谡 ������
				count--;
			}
			else{ //�̱�� ���谡 ������
				ar[i] = Integer.parseInt(line.split(" ")[i]);
			}
		}
		//System.out.print(count);
	}

}
