package com.yh.shopping.model.admin;

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
import com.yh.shopping.model.Reviews;
import com.yh.shopping.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스
	
	@Column(nullable = false, length = 100)
	private String productName; // 상품이름
	
	@Lob
	private String content; // 내용
	
	private int price; // 가격
	
	private int stock; // 재고
	
	private int count; // 조회수
	
	@CreationTimestamp
	private Timestamp createDate; // 날짜
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다 (난 Fk가 아니에요) DB에 칼럼을 만들지 마세요.
	@JsonIgnoreProperties({"products"}) // 무한 참조 방지 (review에서 products를 JSON으로 파싱하지 않는다. 무시한다.)
	@OrderBy("id desc") // 내림 차순 (최신 글이 위로 온다)
	private List<Reviews> Reviews; // 값을 얻기 위해 필요
	
	
}
