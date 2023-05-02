package cogent.infotech.com.DoConnect.controller;

import java.util.List;
import java.util.Optional;

import cogent.infotech.com.DoConnect.entity.Question;
import cogent.infotech.com.DoConnect.service.AnswerService;
import cogent.infotech.com.DoConnect.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;


import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.repository.AnswerRepository;
import cogent.infotech.com.DoConnect.repository.QuestionRepository;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/getallanswers")
	public List<Answer> getAllAnswers(){
		return answerService.getAllAnswers();
	}
	
	@PostMapping("/addanswer")
	public Answer addAnswer(@Validated @RequestBody Answer answer) {
		return answerService.addAnswer(answer);
	}
	
	@GetMapping("/getanswerbyid/{id}")
	public Answer getAnswerById(@PathVariable("id") int id) {
		return answerService.getAnswerById(id);
	}
	
	@PutMapping("/updateanswer")
	public String updateAnswer(@Validated @RequestBody Answer answer) {
		return answerService.updateAnswer(answer);
	}
	
	@DeleteMapping("/deleteanswerbyid/{id}")
	public String deleteAnswerById(@PathVariable("id") int id) {
		return answerService.deleteAnswerById(id);
	}
	
	@GetMapping("/getanswersbyquestionid/{id}")
	public List<Answer> getAnswersByQuestionId(@PathVariable("id") int id) {
		return answerService.getAnswersByQuestionId(id);
	}

	@GetMapping("/getanswersbyquestion")
	public List<Answer> getAnswersByQuestion(@Validated @RequestBody Question question) {
		return answerService.getAnswersByQuestion(questionService.getQuestionByDescription(question.getDescription_question()));
	}
}
