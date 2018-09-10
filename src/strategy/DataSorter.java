package strategy;

public class DataSorter {

	public static void sort(Object[] arr)
	{
		for(int i=arr.length; i>0; i--)
		{
			for(int j=0; j<i-1; j++)
			{
				Comparable o1 = (Comparable)arr[j];
				Comparable o2 = (Comparable)arr[j+1];
				if(o1.comparableTo(o2) == 1)
				{
					swap(arr, j, j+1);
				}
			}
		}
	}

	private static void swap(Object[] arr, int x, int y) {
		// TODO Auto-generated method stub
		Object temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void p(Object[] arr) {
		// TODO Auto-generated method stub
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
