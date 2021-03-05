package linkedListDataStructure;

import java.util.Iterator;

public interface List<E> extends Iterable<E>{

	public void addFirst(E data);
	public void addLast(E data);
	public E removeFirst();
	public E removeLast();
	public E remove(E data);
	public boolean contains(E data);
	public E peekFirst();
	public E peekLast();
	
	
}
