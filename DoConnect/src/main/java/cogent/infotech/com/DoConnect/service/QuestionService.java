package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.Question;

import java.util.List;

public interface QuestionService {

    public Question addQuestion(Question question);
    public String updateQuestion(Question question);
    public String deleteQuestionById(Integer id);
    public List<Question> getAllQuestions();
//    public void getAllQuestionsFalse();
    public List<Question> getQuestionsByText(String text);
    public List<Question> getQuestionsByTopic(String topic);
    public Question getQuestionById(Integer id);
    public Question getQuestionByDescription(String description);
}