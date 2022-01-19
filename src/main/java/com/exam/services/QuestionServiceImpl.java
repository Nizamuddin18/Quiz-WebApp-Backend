package com.exam.services;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;
import com.exam.repo.QuestionRepository;
@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question upadteQuestion(Question question) {
		return this.questionRepository.save(question);

	}

	@Override
	public Set<Question> getQuizzes() {
		return new LinkedHashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesId) {
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public void deleteQuestion(Long quesId) {
		this.questionRepository.deleteById(quesId);
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}


}
