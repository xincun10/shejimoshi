package dp.filter;

public class SesitiveFilter implements Filter{

	@Override
	public String doFilter(String str) {
		String result = str.replace("被就业", "就业").replaceAll("敏感", "");
		return result;
	}

}
