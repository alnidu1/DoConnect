package cogent.infotech.com.service;

import java.util.List;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.entity.*;
import cogent.infotech.com.repository.*;

@Service
public class ChatServiceImpl implements CustomerService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public void addChat(Chat chat) {
		chatRepository.save(chat);
	}
	
	@Override
	public void deleteChatById(int id) {
		chatRepository.deleteById(id);
	}
	
	@Override
	public List<Chat> getAllChat() {
		return chatRepository.findAll();
	}
	
	@Override
	public List<Chat> getAllChatByTouser(String name) {
		return chatRepository.findAllByTouser(name);
	}

	@Override
	public void home() {
		System.out.println("This is the Customer Homepage!");
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}
	
	@Override
	public void updateQuestion(Question question) {
		questionRepository.save(question);
	}
	
	@Override
	public void deleteQuestionById(int id) {
		questionRepository.deleteById(id);
	}
	
	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
	
	@Override
	public List<Question> getAllQuestionsFalse() {
		return (List<Question>)questionRepository.findByStatus("false");
	}
	
	@Override
	public List<Question> getAllQuestionsTrue() {
		return (List<Question>)questionRepository.findByStatus("true");
	}
	
	@Override
	public List<Question> getAllQuestionsByTopic(String topic) {
		return (List)questionRepository.findByTopic(topic);
	}
	
	@Override
	public List<Question> getAllQuestionsById(int id) {
		return (List)questionRepository.findById(id);
	}
	
	@Override
	public List<Answer> getAllAnswersById(int id) {
		return (List)answerRepository.findById(id);
	}
	
	@Override
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	
	@Override
	public void updateAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	
	@Override
	public void deleteAnswerById(int id) {
		answerRepository.deleteById(id);
	}
	
	@Override
	public List<Answer> getAllAnswersByQuestionId(int questionId) {
		return answerRepository.getAllByQuestionId(questionId);
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public List<User> getAllUsers() {
		return (List)userRepository.findAll();
	}
	

	@Override
	public Optional<User> getAllUsersById(int id) {
		return (Optional)userRepository.findById(id);
	}
	
	@Override
	public List<User> getAllUsersByName(String name) {
		return (List)userRepository.findByName(name);
	}
	
	@Override
	public List<User> getAllUsersByUserType(String userType) {
		return (List)userRepository.findByName(userType);
	}

	@Override
	public List<Chat> getAllChatBetweenTwoUsers(String fromuser, String touser) {
		return (List)chatRepository.findAllBetweenTwoUsers(fromuser, touser);
	}

	@Override
	public void addNewUser(User user) {

	}
}
