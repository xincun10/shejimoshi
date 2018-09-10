package dp.filter;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		//process the html tag<>
		String result = str.replace('<','[').replace('>', ']');
		return result;
	}

}
