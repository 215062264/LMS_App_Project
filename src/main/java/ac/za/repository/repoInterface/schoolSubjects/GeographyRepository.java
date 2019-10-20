package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Geography;
import ac.za.repository.IRepository;

import java.util.Set;


public interface GeographyRepository extends IRepository<Geography, String> {
    Set<Geography> getAll();

}