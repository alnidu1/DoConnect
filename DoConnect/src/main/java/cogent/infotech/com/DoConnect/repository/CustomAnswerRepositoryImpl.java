package cogent.infotech.com.DoConnect.repository;

import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomAnswerRepositoryImpl implements CustomAnswerRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Answer> findAnswersByQuestion(Question question) {
        String sql = "Select * from Answers Where question=:question";
        final TypedQuery<Answer> query = entityManager.createQuery(sql, Answer.class);
        query.setParameter("question", question);
        return query.getResultList();
    }
}
