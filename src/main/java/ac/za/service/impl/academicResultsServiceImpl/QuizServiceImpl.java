package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Quiz;
import ac.za.repository.repoInterface.academicResults.QuizRepository;
import ac.za.service.serviceInterface.academicResults.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

    private static QuizServiceImpl service = null;
    @Autowired
    private QuizRepository repository;

    public QuizServiceImpl(QuizRepository repository){
        this.repository = repository;
    }

    @Override
    public Quiz save(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public Quiz findById(Integer id) {
        Optional<Quiz> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Quiz create(Quiz quiz) { quiz  = this.repository.save(quiz);return quiz; }

    @Override
    public Quiz read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Quiz update(Quiz quiz) {
        return this.repository.save(quiz);
    }

    @Override
    public void delete(Integer s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Quiz> getAll() {
        return this.repository.findAll();
    }
}
