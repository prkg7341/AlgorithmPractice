import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

	static Node root;
	static int check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int c = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for(int i=0 ; i<c ; i++){
			check = 0;

			int n = Integer.parseInt(br.readLine().split(" ")[0]); // 성벽 개수

			// 트리 구현
			for(int j=0 ; j<n ; j++){
				String[] input = br.readLine().split(" ");

				int x,y,r;

				x = Integer.parseInt(input[0]);
				y = Integer.parseInt(input[1]);
				r = Integer.parseInt(input[2]);

				if(j==0){
					makeroot(x,y,r);
				}

				else{
					Node pointer = root; // 포인터 노드 생성
					findLocationNMakeNode(pointer,x,y,r);
				}
			}	
			
			if(root.child.size()==0){
				sb.append(String.valueOf(0)+"\n");
			}
			else{
				// 거리 구하기
				int maxDistance = 0;
				int maxDepth = 0;
				int pairDepth = 0;

				Node pointer = root;
				maxDepth = findMaxDepth(pointer, maxDistance);

				// pointer를 이용해 maxDepth에 사용된 root의 child를 삭제
				pointer = root;
				deleteMaxDepthSubTree(pointer, maxDepth);

				if(check>1){
					pairDepth = maxDepth;
				}
				else{
					pointer = root;
					pairDepth = findMaxDepth(pointer, maxDistance);
				}

				maxDistance = maxDepth + pairDepth;
				sb.append(String.valueOf(maxDistance)+"\n");
			}
		}

		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void makeroot(int x, int y, int r){
		root = makeNode(x, y, r);
		root.depth = 0;
	}

	static Node makeNode(int x, int y, int r){
		Node newNode = Node.newInstance(x, y, r);
		return newNode;
	}

	static void findLocationNMakeNode(Node pointer, int x, int y, int r){

		// 점이 해당 노드의 영역에 속하면
		if(pointer.include(x,y)){
			// 해당 노드가 leaf 노드이면
			if(pointer.child.size()==0){
				// 새로운 노드의 반지름이 더 작으면
				if(pointer.r>r){
					Node child = makeNode(x,y,r);
					child.parent = pointer;
					child.depth = child.parent.depth+1;
					pointer.child.add(child);
				}
				// 새로운 노드의 반지름이 더 크면
				else{
					Node parent = makeNode(x,y,r);
					parent.parent = pointer.parent;
					pointer.parent = parent;
					parent.child.add(pointer);
					parent.depth = pointer.depth;
					controlDepth(pointer);
				}
			}
			else{
				Iterator<Node> it = pointer.child.iterator();
				while(it.hasNext()){
					findLocationNMakeNode(it.next(),x,y,r);
				}
			}			
		}
		else if(pointer.parent.include(x, y)){
			Iterator<Node> it = pointer.parent.child.iterator();
			while(it.hasNext()){
				if(it.next().include(x,y)){
					return;
				}
			}			
			Node child = makeNode(x,y,r);
			child.parent = pointer.parent;
			child.depth = child.parent.depth+1;
			pointer.parent.child.add(child);
		}

	}

	static void controlDepth(Node pointer){
		Iterator<Node> it = pointer.child.iterator();
		while(it.hasNext()){
			Node child = it.next();
			child.depth--;
			if(child.child.size()!=0){
				controlDepth(child);
			}
		}		
	}

	static int findMaxDepth(Node pointer, int max){

		max = Math.max(pointer.depth, max);

		Iterator<Node> it = pointer.child.iterator();
		while(it.hasNext()){
			max = Math.max(findMaxDepth(it.next(), max), max);
		}

		return max;
	}

	static void deleteMaxDepthSubTree(Node pointer, int maxDepth){

		if(pointer.depth==maxDepth){
			reverse(pointer);
			check++;
		}
		else{
			Iterator<Node> it = pointer.child.iterator();
			while(it.hasNext()){
				deleteMaxDepthSubTree(it.next(), maxDepth);
			}
		}
	}

	private static void reverse(Node pointer) {
		while(pointer.parent != root){
			pointer = pointer.parent;
		}
		Iterator<Node> it = root.child.iterator();
		while(it.hasNext()){
			Node deleted = it.next();
			if(deleted.include(pointer.x, pointer.y)){
				root.child.remove(deleted);
				return;
			}
		}
	}

	static class Node{
		int x;
		int y;
		int r;
		int depth;
		Node parent;
		CopyOnWriteArrayList<Node> child;

		Node(int x, int y, int r){
			this.x = x;
			this.y = y;
			this.r = r;
			child = new CopyOnWriteArrayList<>();
		}

		public boolean include(int x, int y) {
			if((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y) < r*r)
				return true;
			else
				return false;
		}

		static Node newInstance(int x, int y, int r){
			Node newNode = new Node(x,y,r);
			return newNode;
		}
	}
}
