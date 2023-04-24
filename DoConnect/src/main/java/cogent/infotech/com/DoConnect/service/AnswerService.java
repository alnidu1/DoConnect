package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.Answer;

import java.util.List;

public interface AnswerService {

    public Answer addAnswer(Answer answer);
    public String updateAnswer(Integer id, Answer answer);
    public String deleteAnswerById(Integer answerId);
    public Answer getAnswerById(Integer answerId);
    public List<Answer> getAnswersByQuestionId(Integer questionId);
//    public void getAllAnswersFalse();
}
