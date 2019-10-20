package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Mathematics;
import ac.za.repository.repoInterface.schoolSubjects.MathsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.MathsRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.MathematicsService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MathematicsServiceImpl implements MathematicsService {

    private static MathematicsServiceImpl service = null;
    private MathsRepository repository;

    private MathematicsServiceImpl(){
        this.repository = MathsRepositoryImpl.getRepository();
    }

    public static MathematicsService getService(){
        if (service == null) service = new MathematicsServiceImpl();
        return service;
    }


    @Override
    public Mathematics create(Mathematics course) {
        return this.repository.create(course);
    }

    @Override
    public Mathematics update(Mathematics course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Mathematics read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Mathematics> getAllMath() {
        Set<Mathematics> mathematics = getAll();

        return null;
    }

    @Override
    public Set<Mathematics> getAll() {
        return this.repository.getAll();
    }
}
