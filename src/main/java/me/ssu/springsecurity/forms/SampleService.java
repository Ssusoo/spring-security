package me.ssu.springsecurity.forms;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    // TODO 현재 로그인 한 사용자 정보 참조
    public void dashboard() {
        // TODO Authentication(Principal(정보), GrantAuthority(권한)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // TODO Principal(인증자 정보)
        // TODO Object 임의 Type(사실상 UserDetails Type)
        Object principal = authentication.getPrincipal();

        // TODO GrantAuthority(권한)
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // TODO isAuthenticated(인증된 사용자)
        boolean authenticated = authentication.isAuthenticated();
    }
}
