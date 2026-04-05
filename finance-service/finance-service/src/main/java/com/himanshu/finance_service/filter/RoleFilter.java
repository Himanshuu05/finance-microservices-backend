package com.himanshu.finance_service.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String role = req.getHeader("role");
        String method = req.getMethod();

        if (role == null) {
            throw new RuntimeException("Role header missing");
        }

        if ("VIEWER".equalsIgnoreCase(role) && !method.equals("GET")) {
            throw new RuntimeException("VIEWER cannot modify data");
        }

        if ("ANALYST".equalsIgnoreCase(role) &&
                (method.equals("POST") || method.equals("DELETE"))) {
            throw new RuntimeException("ANALYST cannot create/delete");
        }
        chain.doFilter(request, response);
    }
}