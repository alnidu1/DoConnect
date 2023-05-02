package cogent.infotech.com.DoConnect.controller;

import java.util.List;

import cogent.infotech.com.DoConnect.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import cogent.infotech.com.DoConnect.entity.Question;

@CrossOrigin
@RestController
@RequestMapping("/api/question")
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
