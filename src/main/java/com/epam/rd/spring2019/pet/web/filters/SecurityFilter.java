package com.epam.rd.spring2019.pet.web.filters;



import com.epam.rd.spring2019.pet.config.SecurityConfig;
import com.epam.rd.spring2019.pet.web.dtos.UserViewDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class SecurityFilter implements Filter {

    private SecurityConfig securityConfig = new SecurityConfig();

    public void init(FilterConfig filterConfig) throws ServletException {
        //nothing to init
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String url = httpRequest.getRequestURL().toString();
        HttpSession session = httpRequest.getSession();

        UserViewDto user = null;
        if (session != null && session.getAttribute("user") != null) {
            user = (UserViewDto) session.getAttribute("user");
        }

        Set<String> protectedURLs = new HashSet<>();
        if (user == null) {
            protectedURLs = securityConfig.getProtectedURLsForGuest();
        } else if (!user.isAdmin()) {
            protectedURLs = securityConfig.getProtectedURLsForUser();
        }

        if (isProtectedURL(url, protectedURLs)) {
            httpResponse.sendRedirect("/index");
       } else {
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
        //nothing to release
    }

    private boolean isProtectedURL(String url, Set<String> allowedURLs) {
        boolean result = false;
        if (allowedURLs.size() > 0 ) {
            result = allowedURLs.stream().anyMatch(url::endsWith);
        }

        return result;
    }
}
