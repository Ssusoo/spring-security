package me.ssu.springsecurity.common;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "ssu", roles = "USER")
public @interface TestWithUser {
}
