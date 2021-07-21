package List;

public class LinkedList_jhk<T extends Comparable> {
	Node<T> start = null;
	class Node<T extends Comparable> {
		T data;
		Node<T> next = null;
		public Node(T d, Node<T> n){
			data = d;
			next = n;
		}
	}
	public void insert(T x){
		if (start == null || start.data.compareTo(x) > 0){
			start = new Node<T>(x,start);
			return;
		}
		Node<T> p = start;
		while(p.next != null){
			if(p.next.data.compareTo(x)>0) break;
			p= p.next;
		}
		p.next = new Node<T>(x, p.next);
	}
	boolean delete(T x){
		if(start == null || start.data.compareTo(x)>0)
			return false;
		if(start.data.compareTo(x)==0){
			start = start.next;
			return true;
		}
		for(Node<T> p = start ; p.next != null ; p=p.next){
			if(p.next.data.compareTo(x)>0)break;
			else if(p.next.data.compareTo(x)==0){
				p.next = p.next.next;
				return true;
			}
		}
		return false;
	}
	public void print(){
		for(Node<T> p = start ; p!=null ; p = p.next)
			System.out.print(p.data+" ");
	}
}