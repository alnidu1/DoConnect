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
import cogent.infotech.com.DoConnect.entity.Question;
import cogent.infotech.com.DoConnect.repository.AdminRepository;


@SpringBootApplication
public class DoConnectApplication implements CommandLineRunner{

	@Autowired



	public static void main(String[] args) {
		SpringApplication.run(DoConnectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
