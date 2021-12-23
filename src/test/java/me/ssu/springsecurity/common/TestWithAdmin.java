package me.ssu.springsecurity.common;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "mflo", roles = "ADMIN")
public @interface TestWithAdmin {
}
