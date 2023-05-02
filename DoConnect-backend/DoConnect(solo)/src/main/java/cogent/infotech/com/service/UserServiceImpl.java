package cogent.infotech.com.service;

import java.util.List;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.entity.User;
import cogent.infotech.com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void addNewUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return (List)userRepository.findAll();
	}

	
	@Override
	public Optional<User> getAllUsersById(int id) {
		return (Optional)userRepository.findById(id);
	}
	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public List<User> getAllUsersByName(String name) {
		return (List)userRepository.findByName(name);
	}
	
	@Override
	public List<User> getAllUsersByUserType(String userType) {
		return (List<User>)userRepository.findByUserType(userType);
	}

}