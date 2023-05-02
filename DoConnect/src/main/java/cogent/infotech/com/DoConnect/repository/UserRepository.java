package cogent.infotech.com.DoConnect.repository;
import cogent.infotech.com.DoConnect.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.DoConnect.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
    public User findByUsername(String username);
}
