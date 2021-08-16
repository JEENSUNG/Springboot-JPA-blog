package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //자바 오브젝트를 테이블로 매핑
@Entity //User 클래스가 MySQL에 테이블이 생성됨
//@DynamicInsert // insert시 null인 필드 제외시켜줌
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//프로젝트에서 연결된 DB의 넘버링 전략을 따라가겠다라는 뜻(auto, table 등이 있음)
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 100, unique  = true) //암호화된 비밀번호(해쉬)로 넣을거라 길어야함
	private String username; //아이디
	
	@Column(nullable = false, length = 100)
	private String password; //비밀번호
	
	@Column(nullable = false, length = 50)
	private String email; //이메일
	
	//@ColumnDefault("user") // 써도 되지만 깔끔하지 못함
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	//DB는 RoleType이 없음
	//RoleType이라고 하면 .model에서 지정된 도메인만 사용
	//Enum을 쓰는게 좋음(Domain을 쓸 수 있음)
	//회원 가입했을 때 admin, user, manager이다 등의 권한 관리

	private String oauth; //카카오
	@CreationTimestamp // 시간이 자동 입력됨
	private Timestamp createDate;
}
