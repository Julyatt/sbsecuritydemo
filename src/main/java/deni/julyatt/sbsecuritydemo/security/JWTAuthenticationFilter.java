package deni.julyatt.sbsecuritydemo.security;

import deni.julyatt.sbsecuritydemo.config.TokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService
                .getAuthentication((HttpServletRequest)servletRequest);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
