package proxy2;

import java.lang.reflect.Method;

public class TranscationHandler implements InvocationHandler {

	private Object target;
	
	public TranscationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		// TODO Auto-generated method stub
		System.out.println("Transcation start...");
		try {
			m.invoke(target);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Transcation commit...");
	}

}
