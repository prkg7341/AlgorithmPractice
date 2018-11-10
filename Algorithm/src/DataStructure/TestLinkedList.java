package DataStructure;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList_jhk<Integer> iL = new LinkedList_jhk<Integer>();
		LinkedList_jhk<Double> dL = new LinkedList_jhk<Double>();
		LinkedList_jhk<String> sL = new LinkedList_jhk<String>();
		iL.insert(3);iL.insert(5);iL.insert(1);iL.insert(7);
		dL.insert(3.5);dL.insert(5.2);dL.insert(0.1);dL.insert(7.3);
		sL.insert("Jahee");sL.insert("Bomjun");sL.insert("Kwon");
		iL.print(); dL.print(); sL.print(); System.out.println();
		System.out.println("delete 1: "+iL.delete(1));
		System.out.println("delete 3.0: "+dL.delete(3.0));
		System.out.println("delete Kwon:"+sL.delete("Kwon"));
		System.out.println("After deleting");
		iL.print(); dL.print(); sL.print();
	}
}