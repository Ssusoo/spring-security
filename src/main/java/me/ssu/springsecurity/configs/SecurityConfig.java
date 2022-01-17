package me.ssu.springsecurity.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // TODO 시큐리티 기본 설정(URL)-1
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/info/**", "/account/**").permitAll()
                // TODO ADMIN
                .mvcMatchers("/admin").hasRole("ADMIN")
                // TODO 기타 등등
                .anyRequest().authenticated();
    }
}
