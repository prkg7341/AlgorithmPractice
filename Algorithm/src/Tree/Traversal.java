package Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Traversal {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		Node.root = new Node("");
		Node pointer=null;

		for(int i=0 ; i<n ; i++){
			String value, left, right;
			String[] input = br.readLine().split(" ");
			value = input[0];
			left = input[1];
			right = input[2];
			if(i==0){
				Node.root.value = value;
				Node.root.makeNode(value, left, right);
				pointer = Node.root;
			}
			else{
				pointer = pointer.findlocation(pointer, value);
				pointer.makeNode(value, left, right);
				pointer = Node.root;
			}
		}
		Node.root.preOrder(pointer);
		sb.append("\n");
		Node.root.inOrder(pointer);
		sb.append("\n");
		Node.root.postOrder(pointer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class Node{
		String value;
		Node left;
		Node right;
		static Node root;
		boolean checked = false;

		Node(String value){
			this.value = value;
		}

		Node findlocation(Node pointer, String value) {
			if(pointer==null) return null;
			Node nodeReturned = null;
			if(pointer.value.compareTo(value)==0){
				nodeReturned = pointer;
				return nodeReturned;
			}
			else{
				if(pointer.left!=null){
					Node next = pointer.findlocation(pointer.left, value);
					nodeReturned = next==null? nodeReturned : next;
				}
				if(pointer.right!=null){
					Node next = pointer.findlocation(pointer.right, value);
					nodeReturned = next==null? nodeReturned : next;
				}
			}
			return nodeReturned;
		}
		
		void makeNode(String value, String left, String right){
			if(left.compareTo(".")!=0){
				this.makeLeftNode(left);
			}
			if(right.compareTo(".")!=0){
				this.makeRightNode(right);
			}
		}
		Node makeLeftNode(String value){
			Node newNode = new Node(value);
			this.left = newNode;
			newNode.left = null;
			newNode.right = null;
			return newNode;
		}
		Node makeRightNode(String value){
			Node newNode = new Node(value);
			this.right = newNode;
			newNode.left = null;
			newNode.right = null;
			return newNode;
		}
		public void preOrder(Node pointer) {
			if(!pointer.checked){
				sb.append(pointer.value);
				pointer.checked = true;
			}
			if(pointer.left!=null && !pointer.left.checked){
				preOrder(pointer.left);
			}
			if(pointer.right!=null && !pointer.right.checked){
				preOrder(pointer.right);
			}
			else{
				pointer = root;
			}
		}
		public void inOrder(Node pointer) {
			if(pointer.left!=null && pointer.left.checked){
				inOrder(pointer.left);
			}
			if(pointer.checked){
				pointer.checked = false;
				sb.append(pointer.value);
			}
			if(pointer.right!=null && pointer.right.checked){
				inOrder(pointer.right);
			}
		}
		public void postOrder(Node pointer) {
			if(pointer.left!=null && !pointer.left.checked){
				postOrder(pointer.left);
			}
			if(pointer.right!=null && !pointer.right.checked){
				postOrder(pointer.right);
			}
			if(!pointer.checked){
				pointer.checked = false;
				sb.append(pointer.value);
			}
		}
	}
}
