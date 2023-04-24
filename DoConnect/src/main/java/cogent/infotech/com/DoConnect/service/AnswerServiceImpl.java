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
    private QuestionRepository questionRepo;

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    @Override
    public String updateAnswer(Integer id, Answer answer) {
        Answer answerToUpdate = getAnswerById(id);
        if(answerToUpdate != null) {
            answerToUpdate.setDescription_answer(answer.getDescription_answer());
            answerToUpdate.setImg_src(answer.getImg_src());
            answerToUpdate.setDatetime(answer.getDatetime());
            answerToUpdate.setStatus(answer.getStatus());
            answerRepo.save(answerToUpdate);
            return "Answer with ID#"+id+" has been updated!";
        }
        return "Answer with ID#"+id+" does not exist.";
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
    public List<Answer> getAnswersByQuestionId(Integer questionId) {
        Optional<Question> question = questionRepo.findById(questionId);
        if(question.isPresent())
            return question.get().getAnswers();
        return null;
    }
}
