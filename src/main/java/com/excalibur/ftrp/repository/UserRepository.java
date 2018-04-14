package com.excalibur.ftrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.excalibur.ftrp.properties.User;

@Transactional//开启事务支持
public interface UserRepository extends JpaRepository<User,String>{

}
