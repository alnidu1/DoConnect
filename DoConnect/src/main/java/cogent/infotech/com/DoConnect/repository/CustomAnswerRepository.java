package cogent.infotech.com.DoConnect.repository;

import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.entity.Question;

import java.util.List;

public interface CustomAnswerRepository {
    List<Answer> findAnswersByQuestion(Question question);
}
