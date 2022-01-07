package me.ssu.springsecurity.accounts;

import me.ssu.springsecurity.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class AccountControllerTest extends BaseTest {

    // TODO 스프링 시큐리티 폼 로그인-1(성공)
    // TODO 중복일 때 @Transactional 사용
    @Test
    @DisplayName("유저 생성 후 시큐리티 폼 로그인 한 경우")
    void loginSuccess() throws Exception {
        // TODO Given, 유저 생성(AppProperties)
        // TODO When & Then
        mockMvc.perform(formLogin()
                        .user(appProperties.getUserUsername())
                        .password(appProperties.getUserPassword()))
                .andDo(print())
                // TODO 인증 확인 유무
                .andExpect(authenticated())
        ;
    }

    // TODO 스프링 시큐리티 폼 로그인-3(실패, unauthenticated)
    @Test
    @DisplayName("엉뚱한 유저로 시큐리티 폼 로그인 한 경우")
    void loginFail() throws Exception {
        // TODO Given, 유저 생성(AppProperties)
        // TODO When & Then
        mockMvc.perform(formLogin()
                        .user(appProperties.getUserUsername())
                        .password("123124123"))
                .andDo(print())
                // TODO 인증 확인 유무
                .andExpect(unauthenticated())
        ;
    }
}