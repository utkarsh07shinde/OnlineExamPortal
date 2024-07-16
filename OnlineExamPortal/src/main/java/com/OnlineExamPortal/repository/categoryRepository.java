package com.OnlineExamPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineExamPortal.entity.Category;

@Repository
public interface categoryRepository extends JpaRepository<Category, Long> {

}
