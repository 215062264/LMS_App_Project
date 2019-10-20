package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.BusinessStudies;
import ac.za.repository.IRepository;

import java.util.Set;


public interface BusinessStudiesRepository extends IRepository<BusinessStudies, String> {
    Set<BusinessStudies> getAll();

}