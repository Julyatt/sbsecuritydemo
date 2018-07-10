package deni.julyatt.sbsecuritydemo.pojo;

import org.springframework.security.core.GrantedAuthority;

public class GrandedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrandedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
