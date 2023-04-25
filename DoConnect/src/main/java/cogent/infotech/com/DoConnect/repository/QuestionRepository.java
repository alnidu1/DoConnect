package cogent.infotech.com.DoConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.DoConnect.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>, CustomQuestionRepository {

}
