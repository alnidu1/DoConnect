package cogent.infotech.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import cogent.infotech.com.entity.Question;
import cogent.infotech.com.entity.User;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	@Query(value ="SELECT * From question where status = ?1"
			,nativeQuery = true)
	List<Question> findByStatus(String status);
	@Modifying
	@Transactional
	@Query(value =
			"UPDATE Question q set q.status = ?2, q.qapproved_by = ?3 where q.id = ?1"
			,nativeQuery = true)
	void updateQuestionStatus(int id, String status, int userid);
	Question findById(int id);
	List<Question> findByTopic(String topic);

	default List<Question> findAllPending() {
		return findByStatus("pending");
	}

	default List<Question> findAllApproved() {
		return findByStatus("approved");
	}
}
