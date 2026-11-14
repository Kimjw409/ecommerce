package com.knife.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
    @RequiredArgsConstructor
    public class MemberController {
        //private final MemberRepository memberRepository;
        //private final PasswordEncoder passwordEncoder;
        private final MemberService memberService;

        @GetMapping("/register")
        public String register() {
            return "register.html";
        }

        @PostMapping("/member")
        public String addMember(
                String username,
                String password,
                String displayName
        ) {

            memberService.saveMember(username, password, displayName);

            return "redirect:/list";
        }

        @GetMapping("/login")
        public String login() {
            return "login.html";
        }

        @GetMapping("/my-page")
        public String myPage(Authentication auth) {
            if (auth != null) {
                CustomUser result = (CustomUser) auth.getPrincipal();
                System.out.println(result.displayName);
                return "mypage.html";
            }
            return "mypage.html";
        }

        @GetMapping("/user/1")
        @ResponseBody
        public MemberDto getUser() {
            var a = memberService.findById(1L);
            var result = a.get();
            return new MemberDto(result.getUsername(), result.getDisplayName());

        }
    }

    class MemberDto {
     public String username;
     public String displayName;
     public Long id;

        MemberDto(String username, String displayname) {
            this.username = username;
            this.displayName = displayname;
        }

        MemberDto(String username, String displayname, Long id) {
            this.username = username;
            this.displayName = displayname;
            this.id = id;
        }
    }

