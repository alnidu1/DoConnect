package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.entity.Question;

import java.util.List;

public interface AnswerService {

    public Answer addAnswer(Answer answer);
    public String updateAnswer(Answer answer);
    public String deleteAnswerById(Integer answerId);
    public Answer getAnswerById(Integer answerId);
    public List<Answer> getAnswersByQuestion(Question question);
    public List<Answer> getAnswersByQuestionId(Integer questionId);
    public List<Answer> getAllAnswers();
//    public void getAllAnswersFalse();
}
