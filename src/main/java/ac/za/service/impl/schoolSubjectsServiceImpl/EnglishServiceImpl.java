package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.English;
import ac.za.repository.repoInterface.schoolSubjects.EnglishRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.EnglishRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.EnglishService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class EnglishServiceImpl implements EnglishService {

    private static EnglishServiceImpl service = null;
    private EnglishRepository repository;

    private EnglishServiceImpl(){
        this.repository = EnglishRepositoryImpl.getRepository();
    }

    public static EnglishService getService(){
        if (service == null) service = new EnglishServiceImpl();
        return service;
    }


    @Override
    public English create(English course) {
        return this.repository.create(course);
    }

    @Override
    public English update(English course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public English read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<English> getAllEng() {
        Set<English> englishes = getAll();

        return null;
    }

    @Override
    public Set<English> getAll() {
        return this.repository.getAll();
    }
}
