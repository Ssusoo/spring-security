package me.ssu.springsecurity.index;

import me.ssu.springsecurity.common.BaseTest;
import me.ssu.springsecurity.common.TestWithAdmin;
import me.ssu.springsecurity.common.TestWithUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithAnonymousUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class IndexControllerTest extends BaseTest {

    // TODO 스프링 시큐리티 URL-1(Index Page, Anonymous)
    @Test
    @DisplayName("인증이 안 된 사용자 인덱스 페이지에 접근했을 때")
    @WithAnonymousUser
    void indexAnonymous() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    // TODO 스프링 시큐리티 URL-2(Index Page, User)
    @Test
    @DisplayName("인증된 사용자 인덱스 페이지에 접근했을 때")
    @TestWithUser
    void indexUser() throws Exception {
        mockMvc.perform(get("/"))
//                    .with(user("ssu").roles("USER")))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    // TODO 스프링 시큐리티 URL-3(Admin Page, USER)
    @Test
    @DisplayName("유저인 사용자가 어드민 페이지에 접근했을 때")
    @TestWithUser
    void adminUser() throws Exception {
        mockMvc.perform(get("/admin"))
//                        .with(user("ssu").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden())
        ;
    }

    // TODO 스프링 시큐리티 URL-4(Admin Page, ADMIN)
    @Test
    @DisplayName("어드민인 사용자가 어드민 페이지에 접근했을 때")
    @TestWithAdmin
    void adminAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
//                        .with(user("mflo").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}
