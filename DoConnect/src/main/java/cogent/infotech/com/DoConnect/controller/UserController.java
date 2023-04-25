package cogent.infotech.com.DoConnect.controller;

import java.util.List;

import cogent.infotech.com.DoConnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.com.DoConnect.entity.User;



@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to DoConnect";
	}
	
	@PostMapping("/adduser")
	public User addUser(@Validated @RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUser(){
		return service.getAllUsers();
	}
	
	@GetMapping("/getuserbyid/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/updateuser")
	public String updateUser(@Validated @RequestBody User user){
		return service.updateUser(user);
	}
	
	@GetMapping("/getbyname/{name}")
	public List<User> getByName(@PathVariable("name") String name) {
		return service.getUsersByName(name);
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
