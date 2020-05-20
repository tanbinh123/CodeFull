/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        List<String> urlAllow = Arrays.asList("/login.jsp", "/register.jsp", "/recover.jsp", "/index.jsp");
        if (urlAllow.contains(req.getServletPath()) || req.getServletPath().indexOf("/assets/") == -1 || req.getServletPath().indexOf("/fonts/") == -1) {
            chain.doFilter(request, response);
        }else{
            if(req.getSession().getAttribute("USER") == null){
                res.sendRedirect(req.getContextPath()+"/login.jsp");
            }else{
                chain.doFilter(request, response);
            }
        }        
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
