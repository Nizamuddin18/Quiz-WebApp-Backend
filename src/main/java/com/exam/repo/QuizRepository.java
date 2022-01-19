package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	public List<Quiz> findQuizByCategory(Category category);
	
	public List<Quiz> findByActive(boolean active);
	
	public List<Quiz> findQuizByCategoryAndActive(Category category , boolean active);

}
