package dp.filter;

public class SesitiveFilter implements Filter{

	@Override
	public String doFilter(String str) {
		String result = str.replace("����ҵ", "��ҵ").replaceAll("����", "");
		return result;
	}

}
