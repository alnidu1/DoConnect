package cogent.infotech.com.DoConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cogent.infotech.com.DoConnect.entity.Admin;
import cogent.infotech.com.DoConnect.repository.AdminRepository;

@SpringBootApplication
public class DoConnectApplication implements CommandLineRunner{

	@Autowired
	AdminRepository adminrepo;
	public static void main(String[] args) {
		SpringApplication.run(DoConnectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		adminrepo.save(new Admin("test", "test", "test", "test", "test"));
	}

}
