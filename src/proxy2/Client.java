package proxy2;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UserMgr mgr = new UserMgrImpl();
		InvocationHandler h = new TranscationHandler(mgr);
		UserMgr u = (UserMgr) Proxy.newProxyInstance(UserMgr.class, h);
		u.addUser();
	}

}
