package com.excalibur.ftrp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//开启事务支持
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启后台方法权限控制
public class FtrpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtrpApplication.class, args);
	}
}
