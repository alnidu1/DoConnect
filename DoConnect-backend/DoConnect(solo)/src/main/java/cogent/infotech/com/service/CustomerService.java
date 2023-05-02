package cogent.infotech.com.service;

import java.util.List;
import java.util.Optional;

import cogent.infotech.com.entity.*;

public interface CustomerService {
	
	public void addChat(Chat chat);
	public void deleteChatById(int id);
	public List<Chat> getAllChat();
	public List<Chat> getAllChatByTouser(String name);
	public void addUser(User user);
	public void addQuestion(Question question);
	public void updateQuestion(Question question);
	public void deleteQuestionById(int id);
	public List<Question> getAllQuestions();
	public List<Question> getAllQuestionsFalse();
	public List<Question> getAllQuestionsTrue();
	public List<Question> getAllQuestionsByTopic(String topic);
	public List<Question> getAllQuestionsById(int id);
	public List<Answer> getAllAnswersById(int id);
	public void addAnswer(Answer answer);
	public void updateAnswer(Answer answer);
	public void deleteAnswerById(int id);
	public List<Answer> getAllAnswersByQuestionId(int questionid);
	public void updateUser(User user);
	public List<User> getAllUsers();
	public void home();
	public void addNewUser(User user);
	public void deleteById(int id);
//	public boolean userLoginVerify(User user);
//	public List<String> getLogin(User user);
	public Optional<User> getAllUsersById(int id);
	public List<User> getAllUsersByName(String name);
	public List<User> getAllUsersByUserType(String userType);
	public List<Chat> getAllChatBetweenTwoUsers(String fromuser, String touser);
}