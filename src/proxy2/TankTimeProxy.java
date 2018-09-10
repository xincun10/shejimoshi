package proxy2;
import java.lang.reflect.Method;
public class TankTimeProxy implements proxy2.UserMgr{
	proxy2.InvocationHandler h;
	public TankTimeProxy(InvocationHandler h)
	{
		this.h = h;
	}
@Override
public void addUser(){
	try{
		Method md = proxy2.UserMgr.class.getMethod("addUser");
		h.invoke(this,md);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}