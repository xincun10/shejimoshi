package dp.filter;

public class Main {

	//针对一些敏感词进行处理
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "<script>:)一些敏感词信息，比如被就业";
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
