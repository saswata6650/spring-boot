package com.bharath.springboot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class SimpleFilter1 implements Filter {
   @Override
   public void destroy() {}

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
      throws IOException, ServletException {
	   HttpServletRequest httpRequest = (HttpServletRequest) request;
	   HttpServletResponse httpresponse = (HttpServletResponse) response;
      System.out.println("Remote Host:"+request.getRemoteHost());
      System.out.println("Remote Address:"+request.getRemoteAddr());
      
      //
      String countryCode = httpRequest.getHeader("X-Country-Code");
      System.out.println("COUNTRY CODE :"+countryCode);
      if (!"US".equals(countryCode)) {
    	  HttpServletResponse resp = (HttpServletResponse) response;
          String error = "Invalid API KEY";

          resp.reset();
          resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          resp.setHeader("Error Reason", error);
          response.setContentLength(error .length());
          response.getWriter().write(error);
          	return;
      }
      filterchain.doFilter(request, response);
   }

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {}
}
