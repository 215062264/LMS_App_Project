package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Tutorial;
import ac.za.repository.repoInterface.people.TutorialRepository;
import ac.za.service.serviceInterface.people.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("tutorialService")
public class TutorialServiceImpl implements TutorialService {



    private TutorialRepository repository;

    public TutorialServiceImpl(TutorialRepository repository){ this.repository = repository;}

    @Override
    public Tutorial save(Tutorial tutorial) { return repository.save(tutorial);}

    @Override
    public Tutorial findById(Integer id) {
        Optional<Tutorial> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Tutorial create(Tutorial tutorial) {
        tutorial  = this.repository.save(tutorial);
        return tutorial;
    }

    @Override
    public Tutorial read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Tutorial update(Tutorial tutorial) {
        return this.repository.save(tutorial);
    }

    @Override
    public void delete(Integer s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Tutorial> getAll() {
        return this.repository.findAll();
    }


}
