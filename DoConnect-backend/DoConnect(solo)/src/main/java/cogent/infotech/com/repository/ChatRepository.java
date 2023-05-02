package cogent.infotech.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
import cogent.infotech.com.entity.Chat;
import cogent.infotech.com.entity.User;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{
	
	List<Chat> findAllByTouser(String name);
	
	@Query(value ="SELECT * From chat where (fromuser = ?1 and touser = ?2) or (fromuser = ?2 and touser = ?1)"
			,nativeQuery = true)
	List<Chat> findAllBetweenTwoUsers(String fromuser, String touser);

}
