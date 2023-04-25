package cogent.infotech.com.DoConnect.controller;

import java.util.List;
import java.util.Optional;

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
import cogent.infotech.com.DoConnect.repository.QuestionRepository;

@RestController
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@PostMapping("/addquestion")
	public Question addQuestion(@Validated @RequestBody Question question) {
		return questionRepository.save(question);
	}
	
	@PutMapping("/updatequestion")
	public void updateQuestion(@Validated @RequestBody Question question) {
		questionRepository.save(question);
	}
	
	@DeleteMapping("/deletequestionbyid/{id}")
	public void deleteQuestionById(@PathVariable("id") int id) {
		questionRepository.deleteById(id);
	}
	
	@GetMapping("/getallquestion")
	public List<Question> getAllQuestions(){
		return (List<Question>) questionRepository.findAll();
	}
	
	@GetMapping("/getquestionsbytopic/{topic}")
	public List<Question> getQuestionsByTopic(@PathVariable("topic") String topic){
		return (List<Question>) questionRepository.findAllByTopic(topic);
	}
	
	@GetMapping("/getquestionbyid/{id}")
	public Optional<Question> getQuestionById(@PathVariable("id") int id) {
		return questionRepository.findById(id);
	}
	
	
}
