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
		//�õ���ǰ��Ŀ�ĸ�·��
		System.out.println(System.getProperty("user.dir"));
		
		String filename = System.getProperty("user.dir")
				+"/src/proxy/TankTimeProxy.java";
		File file = new File(filename);
		FileWriter fw = new FileWriter(file);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//�õ�������
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler);
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
		Class c = ul.loadClass("proxy.TankTimeProxy");
		System.out.println(c);
		
		//������Ĺ��췽����������
		//�ҵ���������ΪMoveable�Ĺ��췽��
		Constructor ctr = c.getConstructor(Moveable.class);
		//��������
		Moveable m = (Moveable) ctr.newInstance(new Tank());
		//����move����
		m.move();
	}
}
