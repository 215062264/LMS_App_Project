package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.service.IService;

import java.util.Set;

public interface RegistrationService extends IService<Registration, String> {
    Set<Registration> getAllP();
    Set<Registration> getAll();
}
