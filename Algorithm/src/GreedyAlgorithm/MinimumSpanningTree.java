package GreedyAlgorithm;
import java.util.Scanner;

public class MinimumSpanningTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int pNum = sc.nextInt();//�� ����
		int lNum = sc.nextInt();//���� ����

		int[][] ar = new int[lNum][3];
		int[] tree = new int[pNum-1];//����� Ʈ��
		int[] distance = new int[pNum];//����ġ

		for(int i=0 ; i<lNum ; i++){
			ar[i][0] = sc.nextInt();//������
			ar[i][1] = sc.nextInt();//����
			ar[i][2] = sc.nextInt();//����ġ
		}

		sc.close();//������� ����, �ʱ�ȭ

		//������� ����

		if(pNum==1){
			System.out.println(0);
		}
		else if(pNum==2){
			System.out.println(ar[0][2]);
		}
		else{

			distance[0] = 0;//���õ� ��
			for(int i=1 ; i<distance.length ; i++){
				distance[i] = 1000001;
			}

			for(int l=0 ; l<lNum ; l++){
				for(int p=0 ; p<pNum-1 ; p++){
					if(ar[l][0]==1 && ar[l][1]==(p+2)){
						distance[p+1] = ar[l][2];
					}
				}
			}

			tree[0] = 1;

			int countT=1;			

			while(countT<pNum){
				for(int p=1 ; p<pNum ; p++){
					int min = 1000001;
					int min2 = min;
					min = Math.min(min, distance[p]);
					if(min!=min2){
						tree[countT] = ar[p][1];//������ min�� ���� ��;
					}
					if(ar[p][2]<distance[p]){
						distance[p] = ar[p][2];//����ġ ����
					}
				}
				countT++;				
			}
			System.out.println("# of Tree is " + countT);
			for(int i=0;i<tree.length;i++)
			System.out.print(tree[i]+", ");
			//Tree ���
		}
	}
}