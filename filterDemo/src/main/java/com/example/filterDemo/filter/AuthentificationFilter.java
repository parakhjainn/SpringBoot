package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class AuthentificationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

//        System.out.println("Request entered in authentification filter !");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        System.out.println("Request exiting from authentification filter !");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

         String token = httpServletRequest.getHeader("token");

         if(token == null || !token.equalsIgnoreCase("123456")) {
             httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return;
         }

         filterChain.doFilter(servletRequest, servletResponse);

    }
}
