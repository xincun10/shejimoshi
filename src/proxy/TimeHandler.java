package proxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler{

	//����������Ķ���
	private Object target;
	

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}


	//���ĸ�������õ��ĸ�����
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
