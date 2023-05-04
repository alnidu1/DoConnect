package cogent.infotech.com.service;

import java.util.List;
import java.util.Optional;

import cogent.infotech.com.entity.*;

public interface QuestionService {
	
	public List<Question> getAllQuestions();
	public List<Question> getAllQuestionsFalse();
	public void addQuestion(Question question);
	public void updateQuestionStatus(int id, String newStatus, int userid);
	public void deleteQuestionById(int id);
	public Question getQuestionById(int id);
	public List<Question> getAllQuestionsByTopic(String topic);
	public List<Question> getAllPendingQuestions();
	public List<Question> getAllApprovedQuestions();
	public void approveQuestion(int adminId, Question question);
}