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

import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.repository.AnswerRepository;
import cogent.infotech.com.DoConnect.repository.QuestionRepository;

@RestController
public class AnswerController {
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/getallanswers")
	public List<Answer> getAllAnsers(){
		return (List<Answer>) answerRepository.findAll();
	}
	
	@PostMapping("/addanswer")
	public Answer addAnswer(@Validated @RequestBody Answer answer) {
		return answerRepository.save(answer);
	}
	
	@GetMapping("/getanswerbyid/{id}")
	public Optional<Answer> getAnswerById(@PathVariable("id") int id) {
		return answerRepository.findById(id);
	}
	
	@PutMapping("/updateanswer")
	public void updateAnswer(@Validated @RequestBody Answer answer) {
		answerRepository.save(answer);
	}
	
	@DeleteMapping("/deleteanswerbyid/{id}")
	public void deleteAnswerById(@PathVariable("id") int id) {
		answerRepository.deleteById(id);
	}
	
	@GetMapping("/getanswersbyquestionid/{id}")
	public List<Answer> getAnswersByQuestionId(@PathVariable("id") int id){
		return answerRepository.findAnswersByQuestion(questionRepository.findById(id).get());
	}
}
