package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Lecture;
import ac.za.repository.repoInterface.people.LectureRepository;
import ac.za.service.serviceInterface.people.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service("lectureService")
public class LectureServiceImpl implements LectureService {

    private LectureRepository repository;
    public LectureServiceImpl(LectureRepository repository){ this.repository = repository;}

    @Override
    public Lecture save(Lecture lecture) {
        return repository.save(lecture);
    }

    @Override
    public Lecture findById(Integer id) {
        Optional<Lecture> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Lecture create(Lecture lecture) {
        lecture  = this.repository.save(lecture);
        return lecture;
    }

    @Override
    public Lecture read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Lecture update(Lecture lecture) {
        return this.repository.save(lecture);
    }

    @Override
    public void delete(Integer s) {
        this.repository.deleteById(s);
    }

    @Override
    public List<Lecture> getAll() {
        return this.repository.findAll();
    }
}
