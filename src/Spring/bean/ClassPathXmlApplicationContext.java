package Spring.bean;

import java.util.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object> container= new HashMap<String, Object>();
	
	public ClassPathXmlApplicationContext(String fileName) throws Exception
	{
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader()
				.getResourceAsStream(fileName));
		Element root = doc.getRootElement();
		//System.out.println(root.toString());
		List list = root.getChildren();
		System.out.println(list.size());
		
		//拿到所有的id值和class值
		for(int i=0; i<list.size(); i++)
		{
			Element bean = (Element)list.get(i);
			String id = bean.getAttributeValue("id");
			String clazz = bean.getAttributeValue("class");
			Object o = Class.forName(clazz).newInstance();
			container.put(id, o);
		}
	}
	@Override
	public Object getBean(String id) {
		//读取配置文件
		return container.get(id);
	}

}
