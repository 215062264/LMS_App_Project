package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.repository.repoInterface.schoolSubjects.SubjectRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.SubjectRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SubjectServiceImpl implements SubjectService {

    private static SubjectServiceImpl service = null;
    private SubjectRepository repository;

    private SubjectServiceImpl(){
        this.repository = SubjectRepositoryImpl.getRepository();
    }

    public static SubjectService getService(){
        if (service == null) service = new SubjectServiceImpl();
        return service;
    }


    @Override
    public Subject create(Subject course) {
        return this.repository.create(course);
    }

    @Override
    public Subject update(Subject course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Subject read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Subject> getAllP() {
        Set<Subject> subjects = getAll();

        return null;
    }

    @Override
    public Set<Subject> getAll() {
        return this.repository.getAll();
    }
}
