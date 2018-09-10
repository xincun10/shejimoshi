package complier;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;

import proxy.Moveable;
import proxy.Tank;

import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Test1 {
	public static void main(String[] args) throws Exception
	{
		String rt = "\r\n";
		String src = 
				"package proxy;"+rt
				+"public class TankTimeProxy implements Moveable{"+rt
				+"	Moveable t;"+rt
				+"	public TankTimeProxy(Moveable t)"+rt
				+"	{"+rt
				+"		super();"+rt
				+"		this.t = t;"+rt
				+"	}"+rt
				+"	@Override"+rt
				+"	public void move() {"+rt
				+"	// TODO Auto-generated method stub"+rt
				+"	long start = System.currentTimeMillis();"+rt
				+"	t.move();"+rt
				+"	long end = System.currentTimeMillis();"+rt
				+"	System.out.println(\"time:\"+(end-start));"+rt
				+"	}"+rt
				+"}";
		//拿到当前项目的根路径
		System.out.println(System.getProperty("user.dir"));
		
		String filename = System.getProperty("user.dir")
				+"/src/proxy/TankTimeProxy.java";
		File file = new File(filename);
		FileWriter fw = new FileWriter(file);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//拿到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler);
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
		Class c = ul.loadClass("proxy.TankTimeProxy");
		System.out.println(c);
		
		//根据类的构造方法创建对象
		//找到参数类型为Moveable的构造方法
		Constructor ctr = c.getConstructor(Moveable.class);
		//创建对象
		Moveable m = (Moveable) ctr.newInstance(new Tank());
		//运行move方法
		m.move();
	}
}
