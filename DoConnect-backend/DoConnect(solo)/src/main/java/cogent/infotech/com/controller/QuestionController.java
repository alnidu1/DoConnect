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

@CrossOrigin()
@RestController
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	@PostMapping("/addquestion")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void addQuestion(@Validated @RequestBody Question question) {
		questionService.addQuestion(question);
	}
	

	@PutMapping("/updatequestion/{id}/{status}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void updateQuestion(@Validated @PathVariable("id") int id, 
			@Validated @PathVariable("status") String status,
			@Validated @RequestBody User user) {
		questionService.updateQuestionStatus(id, status, user.getId());
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
	
	@GetMapping("/getallquestionsfalse")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestionsFalse() {
		return questionService.getAllQuestionsFalse();
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

//	@DeleteMapping("/denyquestion")

}

class updateQuestionStatusContent {
	
	int id;
	String status;
	
	public updateQuestionStatusContent(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}