package cogent.infotech.com.DoConnect.repository;

import cogent.infotech.com.DoConnect.entity.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> findUserByName(String name);
}
