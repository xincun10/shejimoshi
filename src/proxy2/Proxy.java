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
		
		//拿到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//拿到编译任务并进行编译
		//得到一个fileManager管理要编译的内容文件
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//根据要编译的内容生成一个编译任务
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		//调用编译任务，生成class文件
		t.call();
		fileMgr.close();
		
		//将class文件加载到内存，并生成新的对象
		URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("proxy2.TankTimeProxy");
		
		//根据类的构造方法创建对象
		//找到参数类型为InvocationHandler的构造方法
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		//创建对象
		Object m = ctr.newInstance(h);
		
		return m;
	}
}
