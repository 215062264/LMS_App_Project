package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Results;
import ac.za.repository.repoInterface.academicResults.ResultRepository;
import ac.za.service.serviceInterface.academicResults.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResultsServiceImpl implements ResultsService {

    private static ResultsServiceImpl service = null;
    @Autowired
    private ResultRepository repository;

    public ResultsServiceImpl(ResultRepository repository){
        this.repository = repository;
    }

    @Override
    public Results save(Results quiz) {
        return repository.save(quiz);
    }

    @Override
    public Results findById(Integer id) {
        Optional<Results> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Results create(Results results) { results  = this.repository.save(results);return results; }

    @Override
    public Results read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Results update(Results results) {
        return this.repository.save(results);
    }

    @Override
    public void delete(Integer s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Results> getAll() {
        return this.repository.findAll();
    }
}
