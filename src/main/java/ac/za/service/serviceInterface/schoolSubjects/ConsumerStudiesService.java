package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.ConsumerStudies;
import ac.za.service.IService;

import java.util.Set;

public interface ConsumerStudiesService extends IService<ConsumerStudies, String> {
    Set<ConsumerStudies> getAllCivil();
    Set<ConsumerStudies> getAll();
}
