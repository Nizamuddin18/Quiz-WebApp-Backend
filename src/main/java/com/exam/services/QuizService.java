package com.exam.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);

	public Quiz upadteQuiz(Quiz quiz);

	public Set<Quiz> getQuizzes();

	public Quiz getQuiz(Long quizId);

	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);

	public List<Quiz> getActiveQuizzes();

	public List<Quiz> getActiveQuizzesOfCategory(Category category);
}
