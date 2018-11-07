package DataStructure;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> iL = new LinkedList<Integer>();
		LinkedList<Double> dL = new LinkedList<Double>();
		LinkedList<String> sL = new LinkedList<String>();
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