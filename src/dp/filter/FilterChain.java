package dp.filter;

import java.util.*;

public class FilterChain implements Filter{

	List<Filter> filters = new ArrayList<Filter>();
	//��ӹ��˹��򣬷������������
	public FilterChain addFilter(Filter f)
	{
		this.filters.add(f);
		return this;
	}
	
	//���ݹ��������ַ������й���
	public String doFilter(String str)
	{
		String r = str;
		for(Filter f:filters)
		{
			r = f.doFilter(r);
		}
		return r;
	}
}
