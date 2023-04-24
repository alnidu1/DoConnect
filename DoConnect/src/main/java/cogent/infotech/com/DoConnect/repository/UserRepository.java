package cogent.infotech.com.DoConnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cogent.infotech.com.DoConnect.entity.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserName(String username);
}
