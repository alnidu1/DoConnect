package cogent.infotech.com.DoConnect.repository;

import cogent.infotech.com.DoConnect.entity.Question;

import java.util.List;

public interface CustomQuestionRepository {

    public List<Question> findAllByText(String text);
    public List<Question> findAllByTopic(String topic);
}
