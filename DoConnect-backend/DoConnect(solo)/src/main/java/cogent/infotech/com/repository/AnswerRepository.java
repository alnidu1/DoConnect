package cogent.infotech.com.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cogent.infotech.com.entity.Answer;
import cogent.infotech.com.entity.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	@Query(value = "SELECT * FROM answer WHERE question_id = ?1", nativeQuery = true)
	List<Answer> findAllByQuestionId(int questionId);

	@Query(value ="SELECT * From answer a where a.status = ?1"
			,nativeQuery = true)
	List<Answer> findByStatus(String status);

	@Query(value ="SELECT * From answer a where a.status = ?1 and a.question_id=?2"
			,nativeQuery = true)
	List<Answer> findByStatus(String status, int question_id);

	@Modifying
	@Transactional
	@Query(value ="UPDATE Answer a set a.status = ?2, a.aapproved_id = ?3 where a.id = ?1"
			,nativeQuery = true)
	void updateAnswerStatus(int id, String status, int user);
	Answer findById(int id);

	@Query(value = "SELECT * From answer a where a.status = ?2 and a.question_id = ?1", nativeQuery = true)
	List<Answer> getAllByQuestionId(int questionId, String status);

	List<Answer> getAllByQuestionId(int questionId);

	default List<Answer> findAllPending() {
		return findByStatus("pending");
	}

	default List<Answer> findAllApproved(int question_id) {
		return findByStatus("approved", question_id);
	}

}
