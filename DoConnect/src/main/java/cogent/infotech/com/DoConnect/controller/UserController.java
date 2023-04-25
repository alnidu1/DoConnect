package cogent.infotech.com.DoConnect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import cogent.infotech.com.DoConnect.repository.UserRepository;
import cogent.infotech.com.DoConnect.entity.User;



@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to DoConnect";
	}
	
	@PostMapping("/adduser")
	public User addUser(@Validated @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User>getAllUser(){
		return (List<User>)userRepository.findAll();
	}
	
	@GetMapping("/getuserbyid/{id}")
	public Optional<User> getUserById(@PathVariable("id") int id) {
		return userRepository.findById(id);
	}
	
	@PutMapping("/updateuser")
	public void updateUser(@Validated @RequestBody User user){
		userRepository.save(user);
	}
	
	@GetMapping("/getbyname/{name}")
	public User getByName(@PathVariable("name") String name) {
		return userRepository.findByUsername(name);
	}
	
	/*
	@GetMapping("/loginVerify")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
	}
	*/
}
