package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.repository.IRepository;

import java.util.Set;

public interface RegistrationRepository extends IRepository<Registration, String> {
    Set<Registration> getAll();

}
