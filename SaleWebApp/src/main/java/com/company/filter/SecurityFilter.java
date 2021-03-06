package com.company.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "SecurityFilter",urlPatterns ={"*"})
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if((!request.getRequestURI().endsWith("login") && !request.getRequestURI().endsWith("error") && !request.getRequestURI().endsWith("signup")) && request.getSession(false).getAttribute("loggedInUser")==null){
            response.sendRedirect("login");
            System.out.println("aueyyyry");
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
