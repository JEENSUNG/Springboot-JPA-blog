package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터일 때 씀
	private String content; //섬머노트 라이브러리	 h티엠엘 태그가 섞여서 디자인됨
	
	private int count; //조회수
	
	@ManyToOne(fetch = FetchType.EAGER) //fk설정. 기본 전략이 eager-> 한명의 유저는 여러 개 게시글을 쓸 수 있다
	@JoinColumn(name = "userId")
	private User user; //DB는 오브젝트를 저장할 수 없다.(FK, 자바는 오브젝트 저장 O)
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) //연관관계의 주인이 아니다.(난 fk가 아님) db에 컬럼 만들지 말라는 의미
	@JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private List<Reply> replys; // 댓글이 한개가 아니기 때문
	
	@CreationTimestamp
	private Timestamp createDate;
}
