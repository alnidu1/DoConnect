	package cogent.infotech.com.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.access.prepost.PreAuthorize;

import cogent.infotech.com.service.QuestionServiceImpl;
import lombok.Data;
import cogent.infotech.com.entity.Answer;
import cogent.infotech.com.entity.Question;
import cogent.infotech.com.entity.User;

@CrossOrigin
@RestController
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	@PostMapping("/addquestion")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void addQuestion(@Validated @RequestBody Question question) {
		questionService.addQuestion(question);
	}
	


	
	@DeleteMapping("/deletequestionbyid/{id}")
	@PreAuthorize("hasRole('admin')")
	public void deleteQuestionById(@Validated @PathVariable("id") int id) {
		questionService.deleteQuestionById(id);
	}
	
	@GetMapping("/getallquestions")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	

	
	@GetMapping("/getallquestionsbytopic")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestionsByTopic(@Validated @RequestBody String topic) {
		return questionService.getAllQuestionsByTopic(topic);
	}
	
	@GetMapping("/getallquestionsbyid/{id}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public Question getQuestionById(@Validated @PathVariable("id") int id) {
		return questionService.getQuestionById(id);
	}

	@GetMapping("/getpendingquestions")
	@PreAuthorize("hasRole('admin')")
	public List<Question> getAllPendingQuestions() {
		return questionService.getAllPendingQuestions();
	}

	@GetMapping("/getapprovedquestions")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllApprovedQuestions() {
		return questionService.getAllApprovedQuestions();
	}

	@PutMapping("/approvequestion/{adminId}")
	@PreAuthorize("hasRole('admin')")
	public void approveQuestion(@Validated @PathVariable("adminId") int adminId,
								@Validated @RequestBody Question question) {
		questionService.approveQuestion(adminId, question);
	}
	
	@PutMapping("/denyquestion")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
    public Question denyQuestion( @Validated @RequestBody Question q) {
		
        return questionService.denyQuestion( q);
    }
	
	@GetMapping("/searchquestions/{s}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> searchQuestion(@Validated @PathVariable("s") String s){
	
		return questionService.searchQuestion(s);
	}


}

