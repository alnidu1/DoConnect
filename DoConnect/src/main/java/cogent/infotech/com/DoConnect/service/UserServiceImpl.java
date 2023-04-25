package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.DoConnect.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public String getLogin(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = repo.findById(id);
        return user.orElse(null);
    }

    @Override
    public String updateUser(User user) {
        User userToUpdate = getUserById(user.getId());
        if(userToUpdate == null)
            return "User with ID#"+user.getId()+" does not exist.";
        userToUpdate.setName(user.getName());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());
        repo.save(userToUpdate);
        return "User with ID#"+user.getId()+" has been updated!";
    }

    @Override
    public List<User> getUsersByName(String name) {
        return repo.findUserByName(name);
    }

    @Override
    public boolean loginVerify() {
        return false;
    }
}
