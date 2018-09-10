package proxy2;

import java.lang.reflect.Method;

public interface InvocationHandler {
	//对哪个对象调用哪个方法
	public void invoke(Object o, Method m);
}
