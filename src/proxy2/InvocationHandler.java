package proxy2;

import java.lang.reflect.Method;

public interface InvocationHandler {
	//���ĸ���������ĸ�����
	public void invoke(Object o, Method m);
}
