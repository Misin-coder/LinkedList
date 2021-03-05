package linkedListDataStructure;

/*
 * This file is a testing file for LinkedList1.java;
 */

public class Tester {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		for(int i = 0; i < 12; i++) {
			list.addLast(i);
		 }
		list.remove(0);
		System.out.println(list.currentSize);
		
		
	
	
	}

}
