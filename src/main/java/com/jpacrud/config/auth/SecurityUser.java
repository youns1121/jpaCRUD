//package com.jpacrud.config.auth;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@Getter
//@Setter
//
//public class SecurityUser implements UserDetails {
//
//    private static final long serialVersionUid=1L;
//
//
//    //field 영역
//
//
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return "test"; //before : null
//    }
//
//    @Override
//    public String getUsername() {
//        return "test"; //before : null
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; //before : false
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; //before : false
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; //before : false
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; //before : false
//    }
//}
