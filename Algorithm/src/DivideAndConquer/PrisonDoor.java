package DivideAndConquer;

import java.util.Scanner;

public class PrisonDoor {

	static void openClose(int[] room, int length){		

		for(int i=0 ; i<length ; i++){

			for(int j=0 ; j<length ; j++){
				
				int index = room[j]/10;
				int bi = room[j]%10;
				
				if(index%(i+1)==0){//����̸�
					if(bi==0){
						room[j]++;
					}
					else if(bi==1){
						room[j]--;
					}
					else{
						System.out.println("Unknown error in bi number in openClose");
					}
				}
			}
		}
	}
	
	static void getAnswer(int[] ar){
		int ans = 0;
		for(int i=0 ; i<ar.length ; i++){
			if(ar[i]%10==1){
				ans++;
			}
			else{
				System.out.println("Unknown error in bi number in getAnswer");
			}
		}

		System.out.println(ans);		
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n,m;
		n = sc.nextInt();//����Ŭ Ƚ��(n)

		for(int i=0 ; i<n ; i++){
			m = sc.nextInt();
			if(m>=5 && m <= 100){
				int[] room = new int [m];
				for(int j=0 ; j<m ; j++){
					room[j] = 10*(j+1)+0;//0�� ��������, ���� �ڸ����ʹ� ���� index+1
				}//�ʱ�ȭ �Ϸ�

				openClose(room, m);

				getAnswer(room);
			}
			else{
				System.out.println("Wrong input");
			}
		}

		sc.close();
	}
}
