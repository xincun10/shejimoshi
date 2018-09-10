package strategy;

public interface Comparable {

	/**
	 * 返回值大于零表示作比较的对象大
	 * 小于零表示被比较的对象大
	 * 等于零表示两个对象相等
	 * @param o
	 * @return
	 */
	public int comparableTo(Object o);
	
}
