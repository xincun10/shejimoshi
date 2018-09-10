package iterator;

import iterator.Collection;
public class LinkedList implements Collection{

	Node head = null;
	Node tail = null;
	int size = 0;
	public void add(Object o)
	{
		Node node = new Node(o, null);
		if(head == null)
		{
			head = node;
			tail = node;
		}
		
		tail.setNext(node);
		tail = node;
		size++;
	}
	public int size()
	{
		return size;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
