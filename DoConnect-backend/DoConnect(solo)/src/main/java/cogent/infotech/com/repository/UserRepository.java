package cogent.infotech.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer>{

	User findByUsername(String username);
	List<User> findByUserType(String userType);
	User findByName(String name);
	
}
