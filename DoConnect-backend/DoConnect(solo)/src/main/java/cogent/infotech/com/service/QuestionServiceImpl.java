package cogent.infotech.com.service;

import cogent.infotech.com.entity.Question;
import cogent.infotech.com.entity.User;
import cogent.infotech.com.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserServiceImpl userService;

	

	@Override
	public List<Question> getAllQuestions() {
		return (List)questionRepository.findAll();
	}
	
	@Override
	public void addQuestion(Question question) {
		ArrayList<User> admins = (ArrayList<User>)userService.getAllUsersByUserType("admin");
		for(int i = 0; i < admins.size(); i++) {

		}
		questionRepository.save(question);
	}
	
	
	
	@Override
	public void deleteQuestionById(int id) {
		questionRepository.deleteById(id);
	}
	
	@Override
	public Question getQuestionById(int id) {
		return questionRepository.findById(id);
	}
	
	@Override
	public List<Question> getAllQuestionsByTopic(String topic) {
		return (List)questionRepository.findByTopic(topic);
	}

	@Override
	public List<Question> getAllPendingQuestions() {
		return questionRepository.findAllPending();
	}

	@Override
	public List<Question> getAllApprovedQuestions() {
		return questionRepository.findAllApproved();
	}

	@Override
	public Question approveQuestion(int id, Question q) {
		
		q.setQapproved_by(userService.findById(id));
		q.setStatus("approved");
		return  questionRepository.save(q);
		        
		
	}
	/*@Override
	public List<Question> searchQuestion(String q) {
		return questionRepository.findByDescriptionQuestionContaining(q);
	}*/
	@Override
	public Question denyQuestion(Question q) {
		q.setStatus("denied");
		return  questionRepository.save(q);
		        
		
	}

	

}