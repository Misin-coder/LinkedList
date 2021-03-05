package linkedListDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList<E> implements List<E>,Iterable<E> {

	Node<E> head;
	Node<E> tail;
	int currentSize;

	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> previous;

		public Node(E data) {
			this.data = data;
			next = null;
			previous = null;
		}
	}
	
	private class IteratorHelper implements Iterator<E> {

		Node<E> index = head;

		public boolean hasNext() {

			return (index != null);

		}

		@Override
		public E next() {
			if (hasNext()) {
				E value = index.data;
				index = index.next;
				return value;
			} else {
				throw new NoSuchElementException();
			}
		}

	}

	public DoublyLinkedList() {
		head = null;
		tail = null;
		currentSize = 0;

	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	@Override
	public void addFirst(E data) {
		Node<E> node = new Node(data);
		if (head == null) {
			head = tail = node;
			currentSize++;
			return;
		}

		head.previous = node;
		node.next = head;
		head = node;
		currentSize++;

	}

	@Override
	public void addLast(E data) {
		Node<E> node = new Node<>(data);
		if (head == null) {
			head = tail = node;
			currentSize++;
			return;
		}

		tail.next = node;
		node.previous = tail;
		tail = node;
		currentSize++;

	}

	@Override
	public E removeFirst() {
		if (head == null) {
			return null;
		}

		E value = head.data;
		if (head == tail) {
			head = tail = null;

		} else {
			head = head.next;
			head.previous = null;
		}
		currentSize--;
		return value;

	}

	@Override
	public E removeLast() {
	
		if(head == null || head == tail) {
			return removeFirst();
		}
		
		E value = tail.data;
		tail = tail.previous;
		tail.next = null;	
		currentSize--;
		return value;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(E data) {
		Node<E> current = head;
		while(current != null) {
			if(((Comparable<E>)current.data).compareTo(data) == 0) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public E peekFirst() {
		if(head == null) {
			return null;
		}
		return head.data;
	}

	@Override
	public E peekLast() {
		if(head == null) {
			return null;
		}
		return tail.data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E data) {
		Node<E> current = head;
		while(current != null) {
			if(((Comparable<E>)current.data).compareTo(data) == 0) {
				if(current == head) {
					return removeFirst();
				} 
				if(current == tail) {
					return removeLast();
				}
				
				E value = current.data;
				
				current.next.previous = current.previous;
				current.previous.next = current.next;
				currentSize--;
				return value;
			}
			current = current.next;
		}
		return null;
	}

}
