package deni.julyatt.sbsecuritydemo.security;

import deni.julyatt.sbsecuritydemo.pojo.GrandedAuthorityImpl;
import jdk.nashorn.internal.runtime.Context;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if ("admin".equals(name) && "admin".equals(password)) {
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new GrandedAuthorityImpl("ROLE_ADMIN"));
            authorities.add(new GrandedAuthorityImpl("AUTH_WRITE"));
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
            return auth;

        } else {
            throw new BadCredentialsException("password error");
        }


    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
