package strategy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat arr[] = {new Cat(1, 2), new Cat(5, 5), new Cat(3, 3)};
		DataSorter.sort(arr);
		DataSorter.p(arr);
	}

}
