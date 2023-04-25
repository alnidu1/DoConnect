package cogent.infotech.com.DoConnect.service;

import cogent.infotech.com.DoConnect.entity.Question;
import org.springframework.stereotype.Service;

import cogent.infotech.com.DoConnect.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository repo;

    @Override
    public Question addQuestion(Question question) {
        return repo.save(question);
    }

    @Override
    public String updateQuestion(Question question) {
        Question questionToUpdate = getQuestionById(question.getId());
        if(questionToUpdate != null) {
            questionToUpdate.setTitle(question.getTitle());
            questionToUpdate.setDescription_question(question.getDescription_question());
            questionToUpdate.setImg_src(question.getImg_src());
            questionToUpdate.setDatetime(question.getDatetime());
            questionToUpdate.setStatus(question.getStatus());
            questionToUpdate.setTopic(question.getTopic());
            repo.save(questionToUpdate);
            return "Question with ID#"+question.getId()+" has been updated!";
        }
        return "Question with ID#"+question.getId()+" does not exist.";
    }

    @Override
    public String deleteQuestionById(Integer id) {
        Question questionToDelete = getQuestionById(id);
        if(questionToDelete == null)
            return "Question with ID#"+id+" does not exist";
        repo.delete(questionToDelete);
        return "Question with ID#"+questionToDelete.getId()+" has been deleted!";
    }

    @Override
    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    @Override
    public List<Question> getQuestionsByText(String text) {
        return repo.findAllByText(text);
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {
        return repo.findAllByTopic(topic);
    }

    @Override
    public Question getQuestionById(Integer id) {
        Optional<Question> question = repo.findById(id);
        return question.orElse(null);
    }

    @Override
    public Question getQuestionByDescription(String description) {
        return repo.findByDescription(description);
    }
}
