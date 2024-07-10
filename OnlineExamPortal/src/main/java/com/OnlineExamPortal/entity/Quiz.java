package com.OnlineExamPortal.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="quizzes")
public class Quiz {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long quizId;
	
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="isActive")
	private boolean isActive = true;
	@Column(name="numOfQuestion")
	private int numOfQuestion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category categories;
	
	@OneToMany(mappedBy = "quiz" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	@OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<QuizResult> quizResults = new ArrayList<>();
	
}
