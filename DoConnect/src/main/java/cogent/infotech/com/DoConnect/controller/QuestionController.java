package cogent.infotech.com.DoConnect.controller;

import java.util.List;

import cogent.infotech.com.DoConnect.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.com.DoConnect.entity.Question;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@PostMapping("/addquestion")
	public Question addQuestion(@Validated @RequestBody Question question) {
		return service.addQuestion(question);
	}
	
	@PutMapping("/updatequestion")
	public String updateQuestion(@Validated @RequestBody Question question) {
		return service.updateQuestion(question);
	}
	
	@DeleteMapping("/deletequestionbyid/{id}")
	public String deleteQuestionById(@PathVariable("id") int id) {
		return service.deleteQuestionById(id);
	}
	
	@GetMapping("/getallquestions")
	public List<Question> getAllQuestions(){
		return service.getAllQuestions();
	}
	
	@GetMapping("/getquestionsbytopic/{topic}")
	public List<Question> getQuestionsByTopic(@PathVariable("topic") String topic){
		return service.getQuestionsByTopic(topic);
	}
	
	@GetMapping("/getquestionbyid/{id}")
	public Question getQuestionById(@PathVariable("id") int id) {
		return service.getQuestionById(id);
	}
}
