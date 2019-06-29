package jsoft.ads.main;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import jsoft.ads.object.IndividualObject;

@WebFilter(urlPatterns= {"/view"})
public class Test implements Filter{
	
	private int count;
	public void init(FilterConfig request)throws ServletException{
		count=0;
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//IndividualObject us = (IndividualObject)
		count++;
		//System.out.println(count);
		
		chain.doFilter(request, response);
	}

}
