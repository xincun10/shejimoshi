package complier;

import java.lang.reflect.Method;

public class Test2 {
	//如何知道一个接口里面有多少个方法
	public static void main(String[] args)
	{
		Method[] methods = proxy.Moveable.class.getMethods();
		for(Method m:methods)
		{
			System.out.println(m);
			System.out.println(m.getName());
		}
	}
}
