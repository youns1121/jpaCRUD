package com.jpacrud.controller;

import com.jpacrud.domain.User;
import com.jpacrud.service.UserMgmtService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "유저 관리 API", tags = "유저 관리 API")
@RequiredArgsConstructor
@RestController
@RequestMapping(value ="/api/v1")
public class UserMgmtController {

    private final UserMgmtService userMgmtService;

    /**
     * 인증을 거치지 않고 모두에게 공개되는 api
     * 스프링 시큐리티에 관계없이 모두 접근 가능
     */

    @GetMapping("/permitAll")
    public User getUserAll() throws Exception{

//        return userMgmtService.getUserAllTest();
        return null;
    }

    /**
     * 인증을 해야 사용할 수 있는 api
     * 스프링 시큐리티 내에서 관리되어야할 URL
     */
    @GetMapping("/auth")
    public User getUserAuth() throws Exception{

//        return userMgmtService.getUserAuth();
        return null;

    }



}
