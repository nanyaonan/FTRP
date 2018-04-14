package com.excalibur.ftrp.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.excalibur.ftrp.repository.UserRepository;

@Configuration
@EnableWebSecurity//启用WEB安全功能
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserRepository userRepository;
	
	@Resource
    private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .formLogin().loginPage("/login")//跳转登陆界面
        .and()
            .authorizeRequests()
                .antMatchers("/").hasAuthority("admin")
                //.antMatchers(HttpMethod.GET,"/").hasRole("admin")//对该路径下的HTTP POST请求必须要经过认证
                .anyRequest().permitAll()//其余路径不需要认证请求
        .and()
            .requiresChannel().antMatchers("/login/form").requiresSecure()//对该路径下的请求重定向到https
        .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//退出映射的路径
                .logoutSuccessUrl("/login")//成功退出后映射的路径
                .permitAll()
        .and()
            .httpBasic()
                .realmName("login")//启用http basic
        .and()
            .rememberMe()
                .tokenValiditySeconds(2419200).key("FTRP");//启用remeber-me功能，设置为四周有效，默认两周，密匙为hyh
	}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.getOne(username);//验证账户
            }
        });
        //auth.jdbcAuthentication().dataSource(dataSource);//基于数据库表进行认证，调用默认的方法进行认证
    }

}
