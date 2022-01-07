package me.ssu.springsecurity.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    // TODO 유저 정보
    //  SecurityConfig에서 /account/**으로 요청 처리해야 됨.
    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount(@ModelAttribute Account account) {
        // TODO 시큐리티 폼 설정(패스워드 매칭시키기)
        return accountService.createNew(account);
    }
}
