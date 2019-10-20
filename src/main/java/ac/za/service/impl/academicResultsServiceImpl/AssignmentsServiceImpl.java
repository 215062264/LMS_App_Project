package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Assignments;
import ac.za.repository.repoInterface.academicResults.AssignmentsRepository;
import ac.za.service.serviceInterface.academicResults.AssignmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("assignmentsServiceImpl")
public class AssignmentsServiceImpl implements AssignmentsService {

    @Qualifier("assignmentsRepository")
    private static AssignmentsServiceImpl service = null;
    @Autowired
    private AssignmentsRepository repository;

    public AssignmentsServiceImpl(AssignmentsRepository repository){ this.repository = repository; }

    @Override
    public Assignments save(Assignments assignments) {
        return repository.save(assignments);
    }

    @Override
    public Assignments findById(Integer id) {
        Optional<Assignments> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Assignments create(Assignments assignments) {
        assignments  = this.repository.save(assignments);
        return assignments;
    }

    @Override
    public Assignments read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Assignments update(Assignments assignments) {
        return this.repository.save(assignments);
    }

    @Override
    public void delete(Integer s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Assignments> getAll() {
        return this.repository.findAll();
    }
}
