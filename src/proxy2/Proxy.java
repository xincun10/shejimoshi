package proxy2;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(Class itfc, InvocationHandler h) throws Exception
	{
		String rt = "\r\n";
		String methodStr = "";
		Method[] methods = itfc.getMethods();
		for(Method m:methods)
		{
			methodStr += "@Override" + rt +
					"public void " + m.getName() +"(){" + rt
					+"	try{"+rt
					+"		Method md = "+itfc.getName()+".class.getMethod(\""
					+m.getName()+"\");"+rt
					+"		h.invoke(this,md);"+rt
					+"	}catch(Exception e){"+rt
					+"		e.printStackTrace();"+rt
					+"	}"+rt
					+"}";
		}
		String src = 
				"package proxy2;"+rt
				+"import java.lang.reflect.Method;"+rt
				+"public class TankTimeProxy implements "+itfc.getName()+"{"+rt
				+"	proxy2.InvocationHandler h;"+rt
				+"	public TankTimeProxy(InvocationHandler h)"+rt
				+"	{"+rt
				+"		this.h = h;"+rt
				+"	}"+rt
				+ methodStr +rt
				+"}";
		
		String filename = System.getProperty("user.dir")
				+"/src/proxy2/TankTimeProxy.java";
		File file = new File(filename);
		FileWriter fw = new FileWriter(file);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//�õ�������
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//�õ��������񲢽��б���
		//�õ�һ��fileManager����Ҫ����������ļ�
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//����Ҫ�������������һ����������
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		//���ñ�����������class�ļ�
		t.call();
		fileMgr.close();
		
		//��class�ļ����ص��ڴ棬�������µĶ���
		URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("proxy2.TankTimeProxy");
		
		//������Ĺ��췽����������
		//�ҵ���������ΪInvocationHandler�Ĺ��췽��
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		//��������
		Object m = ctr.newInstance(h);
		
		return m;
	}
}
