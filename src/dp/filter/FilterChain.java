package dp.filter;

import java.util.*;

public class FilterChain implements Filter{

	List<Filter> filters = new ArrayList<Filter>();
	//添加过滤规则，返回自身的引用
	public FilterChain addFilter(Filter f)
	{
		this.filters.add(f);
		return this;
	}
	
	//根据过滤链对字符串进行过滤
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
