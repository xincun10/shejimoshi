package strategy;

public class CatHeightComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Cat c1 = (Cat)o1;
		Cat c2 = (Cat)o2;
		if(c1.getHeight() > c2.getHeight()) return 1;
		else if(c1.getHeight() < c2.getHeight()) return -1;
		else return 0;
	}

}
