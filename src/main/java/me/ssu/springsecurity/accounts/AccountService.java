package me.ssu.springsecurity.accounts;

import me.ssu.springsecurity.common.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AppProperties appProperties;

    @Autowired
    PasswordEncoder passwordEncoder;

    // TODO 유저네임 조회(DB에서 유저 정보 불러오기)-1
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);

        // TODO NotFound Error
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        // TODO 유저네임 조회(UserDetails Type 변환)-2
        return new User(account.getUsername(), account.getPassword(), authorities(account.getRoles()));
    }

    // TODO 유저네임 조회(Roles 목록을 stream으로 map을 써서 맵핑하기)-3
    private static Collection<? extends GrantedAuthority> authorities(Set<AccountRole> roles) {
        return roles.stream().map(r -> {
            // TODO collect해서 role을 SimpleGrantedAuthority 변환
            return new SimpleGrantedAuthority("ROLE_" + r.name());
        }).collect(Collectors.toSet());
    }

    // TODO 시큐리티 폼 설정(패스워드 매칭 시키기)
    public Account createNew(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
}
