package cogent.infotech.com.DoConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.DoConnect.entity.Answer;
import cogent.infotech.com.DoConnect.entity.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	List<Answer> findAnswersByQuestion(Question question);
}
