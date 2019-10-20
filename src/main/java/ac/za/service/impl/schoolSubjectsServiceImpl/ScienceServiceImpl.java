package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Science;
import ac.za.repository.repoInterface.schoolSubjects.ScienceRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.ScienceRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.ScienceService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ScienceServiceImpl implements ScienceService {

    private static ScienceServiceImpl service = null;
    private ScienceRepository repository;

    private ScienceServiceImpl(){
        this.repository = ScienceRepositoryImpl.getRepository();
    }

    public static ScienceService getService(){
        if (service == null) service = new ScienceServiceImpl();
        return service;
    }


    @Override
    public Science create(Science course) {
        return this.repository.create(course);
    }

    @Override
    public Science update(Science course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Science read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Science> getAllP() {
        Set<Science> sciences = getAll();

        return null;
    }

    @Override
    public Set<Science> getAll() {
        return this.repository.getAll();
    }
}
