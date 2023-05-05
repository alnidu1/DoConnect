package cogent.infotech.com.service;

import java.util.List;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.entity.*;
import cogent.infotech.com.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;
	
	@Override
	public void updateAnswerStatus(int id, String newStatus, int userid) {
		answerRepository.updateAnswerStatus(id , newStatus, userid);
	}

	public List<Answer> getAllAnswers(int id) {
		return (List)answerRepository.findAllByQuestionId(id);
	}

	@Override
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}

	@Override
	public Answer getAnswerById(int id) {
		return answerRepository.findById(id);
	}
	
	@Override
	public void addAnswer(Answer answer) {
        emailService.sendEmail("cogentcapstonetesting@gmail.com", "new answer waiting to be approve", "answer body");

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
		return answerRepository.getAllByQuestionId(questionId, "pending");
	}

	@Override
	public List<Answer> getAllPendingAnswers() {
		return answerRepository.findAllPending();
	}

	@Override
	public List<Answer> getAllApprovedAnswers(int question_id) {
		return answerRepository.findAllApproved(question_id);
	}

	@Override
	public void approveAnswer(int adminId, Answer answer) {
		Answer answerToApprove = answerRepository.findById(answer.getId());
		answerToApprove.setStatus("approved");
		answerToApprove.setAapproved_by(userService.getUserById(adminId));
		answerRepository.save(answerToApprove);
	}

	@Override
	public void denyAnswer(Answer answer) {
		Answer answerToApprove = answerRepository.findById(answer.getId());
		answerToApprove.setStatus("denied");
		answerRepository.save(answerToApprove);
	}
}