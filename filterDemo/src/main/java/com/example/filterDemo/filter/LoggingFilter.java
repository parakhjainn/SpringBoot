package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

//        System.out.println("Request entered in logging filter !");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        System.out.println("Request exiting from logging filter !");

        Long startTime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // Request Logging
        String requestId = UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-Request-ID", requestId);

        // Request Log
        System.out.println("Incoming Request : "
                + httpServletRequest.getMethod() + " "
                + httpServletRequest.getRequestURI());

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {

        } finally {
            Long endTime = System.currentTimeMillis();

            long duration = endTime - startTime;

            // Response status log
            System.out.println("Response status : "
                    + httpServletResponse.getStatus());

            System.out.println("API Response time : " + duration + "ms");
        }

    }
}
