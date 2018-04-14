package com.excalibur.ftrp.properties;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{

    @Id
    @Column(length = 30)
    private String username;//用户名
    @Column(length = 30)
    private String password;//密码
    @Column(length = 10)
    private boolean isenabled;//账户是否禁用
    @Column(length = 30)
    private String fullname;//姓名
    @Column(length = 10)
    private boolean isaccountNonExpired;//账户是否过期
    @Column(length = 10)
    private boolean isaccountNonLocked;//账户是否加锁
    @Column(length = 10)
    private boolean iscredentialsNonExpired;//证书是否过期
    @Column(length = 10)
    private String role;//角色

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean isenabled) {
        this.isenabled = isenabled;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAccountNonExpired(boolean isaccountNonExpired) {
        this.isaccountNonExpired = isaccountNonExpired;
    }

    public void setAccountNonLocked(boolean isaccountNonLocked) {
        this.isaccountNonLocked = isaccountNonLocked;
    }

    public void setCredentialsNonExpired(boolean iscredentialsNonExpired) {
        this.iscredentialsNonExpired = iscredentialsNonExpired;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return isaccountNonExpired;//是否过期
    }

    @Override
    public boolean isAccountNonLocked() {
        return isaccountNonLocked;//是否加锁
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return iscredentialsNonExpired;//证书是否过期
    }

    @Override
    public boolean isEnabled() {
        return isenabled;//是否禁用
    }

}
