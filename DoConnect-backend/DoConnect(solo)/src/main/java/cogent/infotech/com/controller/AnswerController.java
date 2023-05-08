package cogent.infotech.com.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.access.prepost.PreAuthorize;

import cogent.infotech.com.service.AnswerService;
import cogent.infotech.com.service.QuestionService;
import cogent.infotech.com.service.UserService;
import cogent.infotech.com.entity.Answer;
import cogent.infotech.com.entity.Question;
import cogent.infotech.com.entity.User;

@CrossOrigin
@RestController
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService qs;
	@Autowired
	private UserService us;
	
	
	
	@PostMapping("/addanswer/{question_id}/{user_id}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void addAnswer(@Validated @PathVariable("question_id") int question_id, @Validated @PathVariable("user_id") int user_id, @Validated @RequestBody Answer answer) {
		Question q= qs.getQuestionById(question_id);
		answer.setQuestion(q);
		answer.setAcreated_by(us.getUserById(user_id));
		List<Answer> answers = q.getAnswers();
		answers.add(answer);
		q.setAnswers(answers);
		qs.updateAnswers(q);
//		answerService.addAnswer(answer);
	}
	
	
	
	@DeleteMapping("/deleteanswerbyid/{id}")
	@PreAuthorize("hasRole('admin')")
	public void deleteAnswerById(@Validated @PathVariable("id") int id) {
		answerService.deleteAnswerById(id);
	}

	@GetMapping("/getapprovedanswers/{question_id}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Answer> getApprovedAnswers(@Validated @PathVariable("question_id") int question_id) { return answerService.getAllApprovedAnswers(question_id); }

	@GetMapping("/getpendinganswers")
	@PreAuthorize("hasRole('admin')")
	public List<Answer> getPendingAnswers() { return answerService.getAllPendingAnswers(); }
	
//	@GetMapping("/getallanswers/{id}")
//	@PreAuthorize("hasRole('user') || hasRole('admin')")
//	public List<Answer> getAllAnswers(@Validated @PathVariable("id") int id) {
//
//		return answerService.getAllAnswers(id);
//	}
	

	
	@GetMapping("/getallanswersbyquestionid/{questionId}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Answer> getAllAnswersByQuestionId(@Validated @PathVariable("questionId") int questionId) {
		return answerService.getAllAnswersByQuestionId(questionId);
	}

	@PutMapping("/approveanswer/{adminId}")
	@PreAuthorize("hasRole('admin')")
	public void approveAnswer(@Validated @PathVariable("adminId") int adminId,
							  @Validated @RequestBody Answer answer) {
		answerService.approveAnswer(adminId, answer);
	}

	@PutMapping("/denyanswer")
	@PreAuthorize("hasRole('admin')")
	public void denyAnswer(@Validated @RequestBody Answer answer) {
		answerService.denyAnswer(answer);
	}
	
	@GetMapping("/getanswerbyid/{id}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public Answer getAllAnswersById(@Validated @PathVariable int id) {
		return answerService.getAnswerById(id);
	}

	
}

