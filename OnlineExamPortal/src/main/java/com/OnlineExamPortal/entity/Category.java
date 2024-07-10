package com.OnlineExamPortal.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity //this annotation marks this class as an entity .
@Getter
@Setter
@ToString
@Table(name="categories")// this annotation specifies the table name 
//if you dont use @table annotaion hibernate will use class name as table name 
public class Category {
 
	@Id // is used to mark a column as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this strategy will help us to generate the primary key value auto-increment
	private Long catId;
	
	@Column(name="title")// this annotation specifies the column name
	private String title;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "categories" , cascade =CascadeType.ALL)
	@JsonIgnore
	private List<Quiz> quizes= new ArrayList<>();
}
