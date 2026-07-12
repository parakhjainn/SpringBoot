package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
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
         String apiKey = httpServletRequest.getHeader("x-api-key");

         if(token == null || !token.equalsIgnoreCase("123456")) {
             httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return;
         }

         if(apiKey == null || !apiKey.equalsIgnoreCase("secret123")) {
             httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             httpServletResponse.setContentType("application/json");
             httpServletResponse.getWriter().write("{\n" +
                     "    \"message\" : \"Invalid or Missing API key !\"\n" +
                     "}");
             return;
         }

         filterChain.doFilter(servletRequest, servletResponse);

    }
}
