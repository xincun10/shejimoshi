package iterator;

public class Row {
	private int age;
	private int children;
	public Row()
	{
		
	}
	public Row(int age, int children)
	{
		this.age = age;
		this.children = children;
	}
	public int born()
	{
		this.children = this.children + 1;
		return this.children;
	}
}
