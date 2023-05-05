package cogent.infotech.com.service;

import java.util.List;
import java.util.Optional;

import cogent.infotech.com.entity.User;

public interface UserService {
	
	public void addUser(User user);
	public void updateUser(User user);
	public List<User> getAllUsers();
	public void addNewUser(User user);

	public User getUserById(int id);
	public List<User> getAllUsersByName(String name);
	public User getUserByUsername(String username);
	public List<User> getAllUsersByUserType(String userType);
	public User findById(int id);


}