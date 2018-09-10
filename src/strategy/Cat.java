package strategy;

public class Cat implements Comparable{

	private int height;
	private int weight;
	//private Comparator comparator = new CatHeightComparator();
	private Comparator comparator = new CatWeightComparator();
	
	public Comparator getComparator() {
		return comparator;
	}
	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString()
	{
		return height + "| " + weight;
	}
	@Override
	public int comparableTo(Object o) {
		// TODO Auto-generated method stub
		return comparator.compare(this, o);
	}
	public Cat(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
}
