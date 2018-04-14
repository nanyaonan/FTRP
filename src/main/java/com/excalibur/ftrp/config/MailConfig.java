package com.excalibur.ftrp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {

	@Bean
	public MailSender mailSender(Environment env) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getProperty("mailserver.host"));//指定用来发送Email的服务器主机名
		mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));//指定监听端口
		mailSender.setUsername(env.getProperty("mailserver.username"));//设置邮箱服务器认证的用户名
		mailSender.setPassword(env.getProperty("mailserver.password"));//设置邮箱服务器认证的密码
		return mailSender;
	}
	
}
