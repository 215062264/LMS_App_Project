package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.repository.repoInterface.schoolSubjects.RegistrationRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.RegistrationRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static RegistrationServiceImpl service = null;
    private RegistrationRepository repository;

    private RegistrationServiceImpl(){
        this.repository = RegistrationRepositoryImpl.getRepository();
    }

    public static RegistrationService getService(){
        if (service == null) service = new RegistrationServiceImpl();
        return service;
    }


    @Override
    public Registration create(Registration course) {
        return this.repository.create(course);
    }

    @Override
    public Registration update(Registration course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Registration read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Registration> getAllP() {
        Set<Registration> registrations = getAll();

        return null;
    }

    @Override
    public Set<Registration> getAll() {
        return this.repository.getAll();
    }
}
