package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.entity.Question;
import cogent.infotech.com.DoConnect.repository.AnswerRepository;
import cogent.infotech.com.DoConnect.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepo;

    @Autowired
    private QuestionService questionService;

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    @Override
    public String updateAnswer(Answer answer) {
        Answer answerToUpdate = getAnswerById(answer.getId());
        if(answerToUpdate != null) {
            answerToUpdate.setDescription_answer(answer.getDescription_answer());
            answerToUpdate.setImg_src(answer.getImg_src());
            answerToUpdate.setDatetime(answer.getDatetime());
            answerToUpdate.setStatus(answer.getStatus());
            answerRepo.save(answerToUpdate);
            return "Answer with ID#"+answer.getId()+" has been updated!";
        }
        return "Answer with ID#"+answer.getId()+" does not exist.";
    }

    @Override
    public String deleteAnswerById(Integer answerId) {
        Answer answerToDelete = getAnswerById(answerId);
        if(answerToDelete == null)
            return "Question with ID#"+answerId+" does not exist";
        answerRepo.delete(answerToDelete);
        return "Answer with ID#"+answerToDelete.getId()+" has been deleted!";
    }

    @Override
    public Answer getAnswerById(Integer answerId) {
        Optional<Answer> answer = answerRepo.findById(answerId);
        return answer.orElse(null);
    }

    @Override
    public List<Answer> getAnswersByQuestion(Question question) {
        Question returnedQuestion = questionService.getQuestionByDescription(question.getDescription_question());
        if(returnedQuestion == null)
            return null;
        return returnedQuestion.getAnswers();
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Integer questionId) {
        Question returnedQuestion = questionService.getQuestionById(questionId);
        if(returnedQuestion == null)
            return null;
        return returnedQuestion.getAnswers();
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepo.findAll();
    }
}
