package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Physics;
import ac.za.repository.repoInterface.schoolSubjects.PhysicsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.PhysicsRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.PhysicsService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PhysicsServiceImpl implements PhysicsService {

    private static PhysicsServiceImpl service = null;
    private PhysicsRepository repository;

    private PhysicsServiceImpl(){
        this.repository = PhysicsRepositoryImpl.getRepository();
    }

    public static PhysicsService getService(){
        if (service == null) service = new PhysicsServiceImpl();
        return service;
    }


    @Override
    public Physics create(Physics course) {
        return this.repository.create(course);
    }

    @Override
    public Physics update(Physics course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Physics read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Physics> getAllP() {
        Set<Physics> physics = getAll();

        return null;
    }

    @Override
    public Set<Physics> getAll() {
        return this.repository.getAll();
    }
}
