package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Exam;
import ac.za.repository.repoInterface.academicResults.ExamRepository;
import ac.za.service.serviceInterface.academicResults.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    private static ExamServiceImpl service = null;
    @Autowired
    private ExamRepository repository;

    public ExamServiceImpl(ExamRepository repository){
        this.repository = repository;
    }

    @Override
    public Exam save(Exam exam) {
        return repository.save(exam);
    }

    @Override
    public Exam findById(Integer id) {
        Optional<Exam> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Exam create(Exam exam) { exam  = this.repository.save(exam);return exam; }

    @Override
    public Exam read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Exam update(Exam exam) {
        return this.repository.save(exam);
    }

    @Override
    public void delete(Integer s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Exam> getAll() {
        return this.repository.findAll();
    }
}
