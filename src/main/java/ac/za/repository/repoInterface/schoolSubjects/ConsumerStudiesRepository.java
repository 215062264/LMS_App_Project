package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.ConsumerStudies;
import ac.za.repository.IRepository;

import java.util.Set;

public interface ConsumerStudiesRepository extends IRepository<ConsumerStudies, String> {
    Set<ConsumerStudies> getAll();

}