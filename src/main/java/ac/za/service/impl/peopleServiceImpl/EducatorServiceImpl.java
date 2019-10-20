package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Educator;
import ac.za.repository.repoInterface.people.EducatorRepository;
import ac.za.service.serviceInterface.people.EducatorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("educatorService")
public class EducatorServiceImpl implements EducatorService{


   private  EducatorRepository repository;

    public EducatorServiceImpl(EducatorRepository repository){
        this.repository = repository;
    }

    @Override
    public Educator save(Educator educator) {
        return repository.save(educator);
    }

    @Override
    public Educator findById(Integer id) {
        Optional<Educator> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Educator create(Educator educator) {
        educator  = this.repository.save(educator);
        return educator;
    }

    @Override
    public Educator read(Integer s) { return this.repository.findById(s).orElse(null);}

    @Override
    public Educator update(Educator educator) {
        return this.repository.save(educator);
    }

    @Override
    public void delete(Integer s) { this.repository.deleteById(s); }

    @Override
    public List<Educator> getAll() { return this.repository.findAll(); }
}
