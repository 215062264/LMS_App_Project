package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.repository.repoInterface.schoolSubjects.RegistrationRepository;
import java.util.HashSet;
import java.util.Set;

public class RegistrationRepositoryImpl implements RegistrationRepository {

    private static RegistrationRepositoryImpl repository = null;
    private Set<Registration> registrations;

    private RegistrationRepositoryImpl() {
        this.registrations = new HashSet<>();
    }

    private Registration findP(String regNum) {
        return this.registrations.stream()
                .filter(registration -> registration.getRegNum().trim().equals(regNum))
                .findAny()
                .orElse(null);
    }

    public static RegistrationRepository getRepository(){
        if(repository == null) repository = new RegistrationRepositoryImpl();
        return repository;
    }

    public Registration create(Registration registrations){
        this.registrations.add(registrations);
        return registrations;
    }

    public Registration read(String subjectCode){
        Registration registration = findP(subjectCode);
        return registration;
    }

    public Registration update(Registration registration) {
        Registration toDelete = findP(registration.getRegNum());
        if(toDelete != null) {
            this.registrations.remove(toDelete);
            return create(registration);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Registration registration = findP(subjectCode);
        if (registration != null) this.registrations.remove(registration);
    }

    public Set<Registration> getAll(){
        return this.registrations;
    }


}
