package com.jpacrud.util;

import com.jpacrud.enums.StatusEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component // 개발자가 직접 개발한 클래스를 Bean으로 등록하고자 하는 경우
@Slf4j // 로그를 남기기 위해

public class AuthenticationUtil {

    public boolean isAdmin(){

        boolean retVal = false;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try{
            // 인증정보 꺼내오기
            retVal = authentication.getAuthorities().contains(new SimpleGrantedAuthority(StatusEnums.UserRole.SYSTEM_ADMIN.getStatusTitle()));
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return retVal;
    }



}
