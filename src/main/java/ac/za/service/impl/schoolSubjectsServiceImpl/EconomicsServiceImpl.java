package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Economics;
import ac.za.repository.repoInterface.schoolSubjects.EconomicsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.EconomicsRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.EconomicsService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class EconomicsServiceImpl implements EconomicsService {

    private static EconomicsServiceImpl service = null;
    private EconomicsRepository repository;

    private EconomicsServiceImpl(){
        this.repository = EconomicsRepositoryImpl.getRepository();
    }

    public static EconomicsService getService(){
        if (service == null) service = new EconomicsServiceImpl();
        return service;
    }


    @Override
    public Economics create(Economics course) {
        return this.repository.create(course);
    }

    @Override
    public Economics update(Economics course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Economics read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Economics> getAllCivil() {
        Set<Economics> economics = getAll();

        return null;
    }

    @Override
    public Set<Economics> getAll() {
        return this.repository.getAll();
    }
}
