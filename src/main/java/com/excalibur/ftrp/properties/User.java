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
    private String username;
    @Column(length = 30)
    private String password;
    @Column(length = 10)
    private boolean enabled;
    @Column(length = 30)
    private String fullname;
    @Column(length = 10)
    private boolean accountNonExpired;
    @Column(length = 10)
    private boolean accountNonLocked;
    @Column(length = 10)
    private boolean credentialsNonExpired;
    @Column(length = 10)
    private String role;

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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
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
        return accountNonExpired;//是否过期
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;//是否加锁
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;//证书是否过期
    }

    @Override
    public boolean isEnabled() {
        return enabled;//是否禁用
    }

}
