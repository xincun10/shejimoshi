package iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Row row = new Row(5,0);
		int sum = 1;
		for(int i=0; i<20; i++)
		{
			sum += row.born();
		}
	}

}
