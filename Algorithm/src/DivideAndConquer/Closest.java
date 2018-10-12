package DivideAndConquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Closest {

	public Closest(int[][] ar){
		//System.out.println("start");
		int min = Integer.MAX_VALUE; //min�� integer�� ������ �ʱ�ȭ
		xSort(ar);//x��ǥ�� ���ؼ� sort
		System.out.println(getClosest(ar, 0, ar.length-1, min));//�Ÿ����(2, 3, many�� ���ؼ� ����), many�϶��� ������ ����ϸ鼭 �߰������� ����ؾ���
	}

	int getClosest(int[][] ar, int left, int right, int min) {
		//System.out.println("staartt");
		//System.out.println("start rec");
		int pointNum = right-left+1; //���� ����
		int mid = (right+left)/2;
		if (pointNum==2){//���� ������ �ΰ��̸�
			min = distance(ar[left][0], ar[left][1], ar[right][0], ar[right][1]);
		}
		else if(pointNum==3){//���� ������ �����̸�
			min = Math.min(distance(ar[left][0], ar[left][1], ar[left+1][0], ar[left+1][1]), distance(ar[left+1][0], ar[left+1][1], ar[left+2][0], ar[left+2][1]));
			min = Math.min(distance(ar[left][0], ar[left][1], ar[left+2][0], ar[left+2][1]), min);
		}
		else{ //���� ������ 4�� �̻��̸�
			//System.out.println("go to rec");
			min = Math.min(getClosest(ar, left, mid, min), getClosest(ar, mid+1, right, min));
			//System.out.println("rec end");
			//���� ������ �ִ� ��������Ƽ�
			//Y��ǥ��� sort�� ��,
			//�ű⼭ �ּҰ��� ���ؼ� ���ؾ� ��.
			int midL = mid;
			int midR = mid; 
			while(true){
				if(midL!=0){
					if((ar[mid][0] - min) >= ar[midL--][0]) {
						//System.out.println("while break1");
						break;
					}
				}
				else{
					//System.out.println("while break1-1");
					break;
				}
			} 

			while(true){
				if(midR!=right){
					if((ar[mid+1][0] + min) <= ar[midR++][0]) {
						//System.out.println("while break2");
						break;
					}
				}
				else{
					//System.out.println("while break2-1");
					break;
				}
			}

			//System.out.println("midL is "+midL+" midR is "+midR);
			int midNum = midR-midL+1;//�߰����� ���� ����
			//System.out.println("midNUm is "+midNum);
			if(midNum <= 1){//�߰��� �ִ� ���� ������ 1�� ����
				return min;
				//System.out.println("hey1");
			}
			else if(midNum == 2){//�߰��� �ִ� ���� ������ �ΰ�
				min = Math.min(min, distance(ar[midL][0], ar[midL][1], ar[midR][0], ar[midR][1]));
				//System.out.println("hey2");
			}
			else{//�߰��� �ִ� ���� ������ ���� �̻�
				//System.out.println("goto YMIN");
				min = Math.min(min, yMin(ar, midL, midR, min)); //������ �ּҰ��� �߰��� �ּҰ� ��
				//System.out.println("hey3");
			}
		}
		return min;
	}

	private int yMin(int[][] ar, int left, int right, int min) {
		int[][] arY = new int [right-left+1][2]; //y��ǥ ���� sort�� ����
		int minY = min; //�ٲ��� �ʴ� min �� ���� ����
		for(int i=0 ; i < (right-left+1) ; i++){ //�ʿ��� �κи� ����
			arY[i][0] = ar[left+i][0];
			arY[i][1] = ar[left+i][1];
		}
		ySort(arY, 0, arY.length-1); //y��ǥ ���� sort
		for(int i=0 ; i < (right-left) ; i++){
			for(int j=1 ; j<(right-left-i+1) ; j++){
				if(Math.pow((arY[i+j][1]-arY[i][1]),2)<minY){ //y��ǥ���� ���̰� ������ min���� ���� ����
					//System.out.println(arY[i][0]+", "+arY[i][1]+"�� "+arY[i+j][0]+", "+arY[i+j][1]+"�� ���ϰ��ֽ��ϴ�.");
					min = Math.min(distance(arY[i][0], arY[i][1], arY[i+j][0], arY[i+j][1]), min);
				}
			}
		}
		return min;
	}

	private void ySort(int[][] ar, int left, int right) {
		Arrays.sort(ar, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
	}

	int distance(int x1, int y1, int x2, int y2) {
		int d = (int) (Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
		return d;
	}

	void xSort(int[][] ar) {
		Arrays.sort(ar, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
	}

	public static void main(String[] args) throws IOException { 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);

		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();

		int[][] ar = new int[n][2];

		for(int i=0 ; i<n ; i++){
			s = br.readLine().split(" ");
			ar[i][0] = Integer.parseInt(s[0]);
			ar[i][1] = Integer.parseInt(s[1]);
		} //�ʱ�ȭ ��

		//for(int i=0 ; i<n ; i++){System.out.print(ar[i][0] + " ");System.out.println(ar[i][1]);}

		new Closest(ar);//������

		//sc.close();
	}
}