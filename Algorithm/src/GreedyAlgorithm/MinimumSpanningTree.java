package GreedyAlgorithm;
import java.util.Scanner;

public class MinimumSpanningTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int pNum = sc.nextInt();//점 개수
		int lNum = sc.nextInt();//간선 개수

		int[][] ar = new int[lNum][3];
		int[] tree = new int[pNum-1];//출력할 트리
		int[] distance = new int[pNum];//가중치

		for(int i=0 ; i<lNum ; i++){
			ar[i][0] = sc.nextInt();//시작점
			ar[i][1] = sc.nextInt();//끝점
			ar[i][2] = sc.nextInt();//가중치
		}

		sc.close();//여기까지 선언, 초기화

		//여기부터 시작

		if(pNum==1){
			System.out.println(0);
		}
		else if(pNum==2){
			System.out.println(ar[0][2]);
		}
		else{

			distance[0] = 0;//선택된 점
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
						tree[countT] = ar[p][1];//위에서 min을 만든 점;
					}
					if(ar[p][2]<distance[p]){
						distance[p] = ar[p][2];//가중치 수정
					}
				}
				countT++;				
			}
			System.out.println("# of Tree is " + countT);
			for(int i=0;i<tree.length;i++)
			System.out.print(tree[i]+", ");
			//Tree 출력
		}
	}
}