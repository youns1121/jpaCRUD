package com.jpacrud.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("인증을 받습니다.");
        //로그인 로직 시작

        // loginId를 이용하여 DB에서 User 객체를 가져옵니다.
        // User user = mapper.getUser(loginID);
        // User의 정보를 SecurityUser 에 담아줍니다. 이는 생성자를 이용하는 편입니다.!

        return new SecurityUser();
    }
}
