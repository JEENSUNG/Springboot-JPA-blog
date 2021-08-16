package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자동으로 bean등록됨. -> 어노테이션 생략 가능
//-> @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
	//SELECT * FROM user Where username = 1?
	Optional<User> findByUsername(String username);
	// JPA Naming 쿼리
	// Select * from user where username = ? and password = ? 인걸 동작
	//User findByUsernameAndPassword(String username, String password);
	
	//@Query(value = "SELECT * FROM user WHERE username = ? and password = ?", nativeQuery = true)
	//User login(String username, String password);
}
