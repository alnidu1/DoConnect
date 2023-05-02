package cogent.infotech.com.service;

import java.util.List;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.entity.*;
import cogent.infotech.com.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public List<Question> getAllQuestionsFalse() {
		return (List)questionRepository.findByStatus("false");
	}

	@Override
	public List<Question> getAllQuestions() {
		return (List)questionRepository.findAll();
	}
	
	@Override
	public void addQuestion(Question question) {
		ArrayList<User> admins = (ArrayList<User>)userService.getAllUsersByUserType("admin");
		for(int i = 0; i < admins.size(); i++) {
			emailService.sendEmail(admins.get(i).getEmail(),
					"Dear "+ admins.get(i).getUsername()+",\n\n"
					+"A new question needs to be approved.\n\n"
					+ "Question title: " + question.getTitle() + "\nQuestion Description: " + question.getDescription_question()+"\n"
					+"\nThank you,\nFrom DoConnect Email Service.",
					"A new question needs to be approved");
		}
		questionRepository.save(question);
	}
	
	@Override
	public void updateQuestionStatus(int id, String newStatus, int userid) {
		questionRepository.updateQuestionStatus(id , newStatus, userid);
	}
	
	@Override
	public void deleteQuestionById(int id) {
		questionRepository.deleteById(id);
	}
	
	@Override
	public List<Question> getAllQuestionsById(int id) {
		return (List)questionRepository.findById(id);
	}
	
	@Override
	public List<Question> getAllQuestionsByTopic(String topic) {
		return (List)questionRepository.findByTopic(topic);
	}

}