package cogent.infotech.com.DoConnect;

import cogent.infotech.com.DoConnect.entity.User;
import cogent.infotech.com.DoConnect.repository.UserRepository;
import cogent.infotech.com.DoConnect.service.AdminService;
import cogent.infotech.com.DoConnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cogent.infotech.com.DoConnect.entity.Admin;
import cogent.infotech.com.DoConnect.repository.AdminRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DoConnectApplication implements CommandLineRunner{

	@Autowired
	private AdminRepository adminrepo;

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DoConnectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		adminService.createAdmin(new Admin("admin_firstname", "admin_lastname", "admin_username", "admin_password", "admin@gmail.com"));
	}

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User("user1", "username1", "password1", "user1@gmail.com"),
				new User("user2", "username2", "password2", "user2@gmail.com"),
				new User("user3", "username3", "password3", "user3@gmail.com")
		).collect(Collectors.toList());
		userRepo.saveAll(users);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
