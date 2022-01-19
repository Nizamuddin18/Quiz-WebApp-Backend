package com.exam.Controller;

import java.util.List;

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

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	@Autowired
	private QuizService quizService;

	// add Quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addCategory(@RequestBody Quiz quiz) {
		Quiz quiz1 = this.quizService.addQuiz(quiz);
		return ResponseEntity.ok(quiz1);
	}

	// get Quiz
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		return this.quizService.getQuiz(quizId);
	}

	// get All Quizzes
	@GetMapping("/")
	public ResponseEntity<?> getQuizes() {
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}

	// update Quiz
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizService.upadteQuiz(quiz);
	}

	// delete Quiz
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
		this.quizService.deleteQuiz(quizId);
	}
	
	//get Quiz based on Category
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
	// get Quiz based on Category and is Active
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid) {
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
	
	// get Quiz based on Active
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes() {
		return this.quizService.getActiveQuizzes();
	}
}
