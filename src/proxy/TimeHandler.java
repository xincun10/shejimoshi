package proxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler{

	//真正被代理的对象
	private Object target;
	

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}


	//对哪个对象调用的哪个方法
	@Override
	public void invoke(Object o, Method m) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		try {
			m.invoke(target);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
	}

}
