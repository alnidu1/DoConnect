package cogent.infotech.com.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.com.service.UserServiceImpl;
import cogent.infotech.com.entity.User;

import org.springframework.http.HttpHeaders;


@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@PostMapping("/adduser")
	public void addUser(@Validated @RequestBody User user) {
		userService.addUser(user);
	}
	
	@PostMapping("/addnewuser")
	public void addNewUser(@Validated @RequestBody User user) {
		userService.addNewUser(user);
	}
	
	@PostMapping("/updateuser")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public void updateUser(@Validated @RequestBody User user) {
		userService.updateUser(user);
	}
	
	
	@GetMapping("/getallusers")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
//	@GetMapping("/getallusersbyid")
//	@PreAuthorize("hasRole('user') || hasRole('admin')")
//	public Optional<User> getAllUsersById(@Validated @RequestBody int id) {
//		return userService.getAllUsersById(id);
//	}
	
	@GetMapping("/getuserbyid/{id}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public User getUserById(@Validated @PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getallusersbyname")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getAllUsersByName(@Validated @RequestBody String name) {
		return userService.getAllUsersByName(name);
	}

	@GetMapping("/getuserbyusername/{username}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public User getUserByUsername(@Validated @PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@GetMapping("/getallusersbytype")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getAllUsersByUserType(@Validated @RequestBody String userType) {
		return userService.getAllUsersByUserType(userType);
	}
	
	@GetMapping("/getallusersbytype/{type}")
	@PreAuthorize("hasRole('user') || hasRole('admin')")
	public List<User> getAllUsersByUserTypePath(@Validated @PathVariable("type") String userType) {
		return userService.getAllUsersByUserType(userType);
	}

}