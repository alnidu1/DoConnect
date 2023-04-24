package cogent.infotech.com.DoConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.DoConnect.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{

}
