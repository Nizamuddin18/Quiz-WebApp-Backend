package com.exam.services;

import java.util.Set;
import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);

	public Question upadteQuestion(Question question);

	public Set<Question> getQuizzes();

	public Question getQuestion(Long quesId);

	public void deleteQuestion(Long quesId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
}
