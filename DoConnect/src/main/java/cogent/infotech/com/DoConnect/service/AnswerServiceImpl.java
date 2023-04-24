package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository repo;


}
