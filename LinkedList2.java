package linkedListDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList2<E> implements Iterable<E> {

	Node<E> head;
	Node<E> tail;
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

	public LinkedList2() {
		head = null;
		tail = null;
		currentSize = 0;
	}

	public void addFirst(E data) {
		Node<E> node = new Node<>(data);
		if (head == null) {
			head = tail = node;
			currentSize++;
			return;
		}
		node.next = head;
		head = node;
		currentSize++;

	}

	public void addLast(E data) {
		Node<E> node = new Node<>(data);
		if (head == null) {
			addFirst(data);
			currentSize++;
			return;
		}
		tail.next = node;
		tail = node;
		currentSize++;
	}

	public E removeFirst() {

		if (head == null) {
			return null;
		}
		E value = head.data;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		currentSize--;
		return value;
	}

	public E removeLast() {
		if (head == null) {
			return null;
		}
		E value = tail.data;
		if (head == tail) {
			head = tail = null;
		} else {
			Node<E> previous = null, current = head;
			while (current != tail) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			tail = previous;
		}
		currentSize--;
		return value;
	}

	public E remove(E data) {
		Node<E> previous = null, current = head;
		while (current != null) {
			if (((Comparable<E>) (current.data)).compareTo(data) == 0) {
				if (current == head) {
					return removeFirst();
				}
				previous.next = current.next;
				currentSize--;
				return current.data;
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
			if (((Comparable<E>) (current.data)).compareTo(data) == 0) {
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
		return tail.data;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

}
