package dp.filter;

public class Main {

	//���һЩ���дʽ��д���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "<script>:)һЩ���д���Ϣ�����类��ҵ";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		FilterChain fc = new FilterChain();
		FilterChain fc2 = new FilterChain();
		fc.addFilter(new HTMLFilter());
		fc2.addFilter(new SesitiveFilter());
		fc.addFilter(fc2);
		mp.setFc(fc);
		String result = mp.process();
		System.out.println(result);
	}

}
