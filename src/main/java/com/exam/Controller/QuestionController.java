package com.exam.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	// add Question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		Question question1 = this.questionService.addQuestion(question);
		return ResponseEntity.ok(question1);
	}

	// get Question
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Long questionId) {
		return this.questionService.getQuestion(questionId);
	}

	// get All Question
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getAllQuestionofAnyQuiz(@PathVariable("quizId") Long quizId) {
		Quiz quiz = this.quizService.getQuiz(quizId);
		Set<Question> questionSet = quiz.getQuestions();
		List list = new ArrayList<>(questionSet);
		if(list.size() > Integer.parseInt(quiz.getNoOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNoOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	// get All Question
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<?> getAllQuestionofAdmin(@PathVariable("quizId") Long quizId) {
		Quiz quiz = new Quiz();
		quiz.setQid(quizId);
		Set<Question> allQuestion = this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(allQuestion);
	}
		
	// update Question
	@PutMapping("/")
	public Question updateQuestion(@RequestBody Question question) {
		return this.questionService.upadteQuestion(question);
	}

	// delete Question
	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestion(questionId);
	}

}
