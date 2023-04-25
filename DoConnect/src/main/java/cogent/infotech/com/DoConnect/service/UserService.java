package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public String getLogin(User user);
    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public String updateUser(User user);
    public List<User> getUsersByName(String name);
    public boolean loginVerify();
}
