package complier;

import java.lang.reflect.Method;

public class Test2 {
	//���֪��һ���ӿ������ж��ٸ�����
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
