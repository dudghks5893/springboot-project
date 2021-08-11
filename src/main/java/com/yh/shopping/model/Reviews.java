package com.yh.shopping.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@Entity
public class Reviews {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스
	
	@Column(nullable = false, length = 10)
	private int score; // 점수
	
	@Lob
	private String content; // 내용
	
	@CreationTimestamp
	private Timestamp createDate; // 날짜
	
	@ManyToOne // 여러개의 리뷰는 하나의 상품에 존제 할 수 있다.
	@JoinColumn(name="productsId") // 어떤 상품에 리뷰를 적는지 알기 위함
	private Products products;
	
	@ManyToOne
	@JoinColumn(name="userId") // 누가 리뷰를 적었는지 알기 위함
	private User user;
	
}
