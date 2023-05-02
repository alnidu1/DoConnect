package cogent.infotech.com.DoConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cogent.infotech.com.DoConnect.entity.Admin;
import cogent.infotech.com.DoConnect.entity.Question;
import cogent.infotech.com.DoConnect.repository.AdminRepository;
import cogent.infotech.com.DoConnect.repository.QuestionRepository;

@SpringBootApplication
public class DoConnectApplication implements CommandLineRunner{

	@Autowired
	AdminRepository adminrepo;
	@Autowired
	QuestionRepository questionrepo;
	public static void main(String[] args) {
		SpringApplication.run(DoConnectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		adminrepo.save(new Admin("test", "test", "test", "test", "test"));
		questionrepo.save(new  Question("title","description_question", "String img_src", "String datetime", "String status", "String topic"));
	}

}
