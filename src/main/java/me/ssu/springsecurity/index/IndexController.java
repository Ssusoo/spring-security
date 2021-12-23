package me.ssu.springsecurity.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    // TODO Home Page, 둘 다 접근 가능
    @GetMapping
    public String index(Model model, Principal principal) {
        // TODO 인증 안 된 사용자가 로그인 한 경우
        if (principal == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            // TODO 로그인 한 사용자
            model.addAttribute("message", "Hello, " + principal.getName());
        }
        return "index";
    }

    // TODO Info Page, 인증하지 않아도 가능
    @GetMapping("info")
    public String info(Model model) {
        model.addAttribute("message", "Info");
        return "info";
    }

    // TODO Dashboard Page, 로그인한 사용자만
    @GetMapping("dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "Hello " + principal.getName());
        return "dashboard";
    }

    // TODO Admin Page, Admin 권한을 가진 사용자만
    @GetMapping("admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Hello Admin, " + principal.getName());
        return "admin";
    }
}
