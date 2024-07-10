package com.OnlineExamPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long queId;
	
	@Column(name="content")
	private String content;
	@Column(name="image")
	private String image;
	@Column(name="option1")
	private String option1;
	@Column(name="option2")
	private String option2;
	@Column(name="option3")
	private String option3;
	@Column(name="option4")
	private String option4;
	@Column(name="answer")
	private String answer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
	
}
