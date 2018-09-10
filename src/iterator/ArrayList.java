package iterator;

import iterator.Collection;
public class ArrayList implements Collection{

	Object[] objects = new Object[10];
	int index = 0;
	public void add(Object o)
	{
		if(index == objects.length)
		{
			Object[] newObjects = new Object[objects.length * 2];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects = newObjects;
		}
		objects[index] = o;
		index++;
	}
	public int size()
	{
		return index;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	//定义一个内部类
	private class ArrayListIterator implements Iterator
	{
		private int currentIndex = 0;
		
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return objects[currentIndex++];
		}

		@Override
		public boolean hasNext() {
			if(currentIndex >= index)
				return false;
			else 
				return true;
		}
		
	}
}
