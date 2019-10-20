package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.BusinessStudies;
import ac.za.service.IService;

import java.util.Set;

public interface BusinessStudiesService extends IService<BusinessStudies, String> {
    Set<BusinessStudies> getAllBusiness();
    Set<BusinessStudies> getAll();
}
