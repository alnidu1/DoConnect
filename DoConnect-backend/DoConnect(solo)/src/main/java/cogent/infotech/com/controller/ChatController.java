package cogent.infotech.com.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import cogent.infotech.com.service.ChatServiceImpl;
import cogent.infotech.com.entity.*;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ChatController {
	
	@Autowired
	private ChatServiceImpl customerService;
	
	@PostMapping("/user/adduser")
	public void addUser(@Validated @RequestBody User user) {
		customerService.addUser(user);
	}
	
	@PostMapping("/user/updateuser")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void updateUser(@Validated @RequestBody User user) {
		customerService.updateUser(user);
	}
	

	
	@GetMapping("/user/getbyusername")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getByUsername(@Validated @RequestBody String name) {
		return customerService.getAllUsersByName(name);
	}
	
	@GetMapping("/user/getallusers")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getAllCustomer() {
		return customerService.getAllUsers();
	}
	
	@GetMapping("/user/getallusersbytype")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getAllCustomer(@Validated @RequestBody String userType) {
		return customerService.getAllUsersByUserType(userType);
	}
	
	@DeleteMapping("/user/deletebyid/{id}")
	@PreAuthorize("hasRole('admin')")
	public void deleteUserById(@Validated @PathVariable("id") int id) {
		customerService.deleteById(id);
	}
	
	@PostMapping("/question/addquestion")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void addQuestion(@Validated @RequestBody Question question) {
		customerService.addQuestion(question);
	}
	
	@PostMapping("/question/updatequestion")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void updateQuestion(@Validated @RequestBody Question question) {
		customerService.updateQuestion(question);
	}
	
	@GetMapping("/question/getallquestionsfalse")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestionsFalse() {
		return customerService.getAllQuestionsFalse();
	}
	
	@GetMapping("/question/getallquestionstrue")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestionsTrue() {
		return customerService.getAllQuestionsTrue();
	}
	
	@GetMapping("/question/getallquestions")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestions() {
		return customerService.getAllQuestions();
	}
	
	@GetMapping("/question/getallquestionsbytopic")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Question> getAllQuestionsByTopic(@Validated @RequestBody String questionTopic) {
		return customerService.getAllQuestionsByTopic(questionTopic);
	}
	
	@DeleteMapping("/question/deletebyid/{id}")
	@PreAuthorize("hasRole('admin')")
	public void deleteQuestionById(@Validated @PathVariable int id) {
		customerService.deleteQuestionById(id);
	}
	
	@PostMapping("/answer/addanswer")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void addAnswer(@Validated @RequestBody Answer answer) {
		customerService.addAnswer(answer);
	}
	
	@PostMapping("/answer/updatequestion")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void updateAnswer(@Validated @RequestBody Answer answer) {
		customerService.updateAnswer(answer);
	}
	
	@GetMapping("/answer/getanswerbyid")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Answer> getAllAnswersById(@Validated @RequestBody int id) {
		return customerService.getAllAnswersById(id);
	}
	
	@GetMapping("/answer/getallanswersbyquestionid")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Answer> getAllAnswersByQuestionId(@Validated @RequestBody int id) {
		return customerService.getAllAnswersByQuestionId(id);
	}
	
	@DeleteMapping("/answer/deletebyid")
	@PreAuthorize("hasRole('admin')")
	public void deleteAnswerById(@Validated @RequestBody int id) {
		customerService.deleteAnswerById(id);
	}
	
	@PostMapping("/chat/addchat")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void addChat(@Validated @RequestBody Chat chat) {
		customerService.addChat(chat);
	}
	
	@GetMapping("/chat/getallchats")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Chat> getAllChats() {
		return customerService.getAllChat();
	}
	
	@GetMapping("/chat/getallchatsbytouser")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Chat> getAllChatsByName(@Validated @RequestBody Chat chat) {
		System.out.println(chat.getTouser());
		return customerService.getAllChatByTouser(chat.getTouser());
	}
	
	@GetMapping("/chat/getallchatbetweentwousers")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Chat> getAllChatBetweenTwoUsers(@Validated @RequestBody FromUserToUser futu){
		return customerService.getAllChatBetweenTwoUsers(futu.getFromuser(), futu.getTouser());
	}
	
	@GetMapping("/chat/getallchatbetweentwousers/{fromuser}/{touser}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<Chat> getAllChatBetweenTwoUsersPath(@Validated @PathVariable("fromuser") String fromuser,
			@Validated @PathVariable("touser") String touser){
		return customerService.getAllChatBetweenTwoUsers(fromuser, touser);
	}
	
	@DeleteMapping("/chat/deletebyid")
	@PreAuthorize("hasRole('admin')")
	public void deleteChatById(@Validated @RequestBody int id) {
		customerService.deleteChatById(id);
	}

}
class FromUserToUser{
	String fromuser;
	String touser;
	
	public FromUserToUser(String fromuser, String touser) {
		super();
		this.fromuser = fromuser;
		this.touser = touser;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	
}
