package linkedListDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *  This file contains linkedList having only head pointer i.e no tail pointer
 * 
 */

/*
 * Boundary conditions are:
 *   1. empty data structure;
 *   2. single element in the data structure;
 *   3. operation at the beginning.
 *   4. operation  at the last.
 *   5. working in the middle
 */

/*
 *    TIP :
 * Think about the general case always;
 */
public class LinkedList1<E> implements Iterable<E> {

	Node<E> head;
	int currentSize;
 
	private class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	private class IteratorHelper implements Iterator<E> {
		Node<E> index = head;

		@Override
		public boolean hasNext() {

			return (index != null);
		}

		@Override
		public E next() {
			if (hasNext()) {
				E value = index.data;
				index = index.next;
				return value;
			}
			throw new NoSuchElementException();
		}

	}

	public LinkedList1() {
		this.head = null;
		currentSize = 0;
	}

	public void addFirst(E data) {
		Node<E> node = new Node<E>(data);
		node.next = head;
		head = node;
		currentSize++;
	}

	public void addLast(E data) {
		Node<E> node = new Node<E>(data);
		Node<E> temp = head;
		if (head == null) {
			head = node;
			currentSize++;
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		currentSize++;
	}

	public E removeFirst() {
		if (head == null) {
			return null; // we can also throw a exception
		}

		E value = head.data;
		head = head.next;
		currentSize--;
		return value;
	}

	public E removeLast() {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return removeFirst();
		}

		Node<E> previous = null, current = head;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		E value = current.data;
		previous.next = current.next;
		currentSize--;
		return value;
	}

	@SuppressWarnings("unchecked")
	public E remove(E data) {
		Node<E> previous = null, current = head;

		while (current != null) {
			if (((Comparable<E>) current.data).compareTo(data) == 0) {
				if (current == head) {
					return removeFirst();
				}

				E value = current.data;
				previous.next = current.next;
				currentSize--;
				return value;

			}
			previous = current;
			current = current.next;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean contains(E data) {
		Node<E> current = head;
		while (current != null) {
			if (((Comparable<E>) current.data).compareTo(data) == 0) {
				return true;

			}
			current = current.next;
		}

		return false;
	}

	public E peekFirst() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	public E peekLast() {
		if (head == null) {
			return null;
		}
		Node<E> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

}



