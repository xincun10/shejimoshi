package Spring.bean;

public class Test {

	public static void main(String args[]) throws Exception
	{
		BeanFactory f = new 
				ClassPathXmlApplicationContext("Spring/bean/applicationContext.xml");
		Object o = f.getBean("car");
		Moveable m = (Moveable) o;
		m.run();
	}
}
