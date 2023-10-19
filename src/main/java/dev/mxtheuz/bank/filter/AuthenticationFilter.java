package dev.mxtheuz.bank.filter;

import dev.mxtheuz.bank.application.services.JwtService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Autowired
    private JwtService jwtService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if(uri.contains("/api/transaction") || uri.contains("/api/user")) {

            var authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null) {
                response.sendError(401);
            } else {
                String token = authorizationHeader.substring("Bearer ".length());
                if(token.isEmpty()) {
                    response.sendError(401);
                } else {
                    String userId = this.jwtService.decodeToken(token);
                    request.setAttribute("userId", userId);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
