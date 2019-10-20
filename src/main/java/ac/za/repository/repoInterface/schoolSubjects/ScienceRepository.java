package ac.za.repository.repoInterface.schoolSubjects;


import ac.za.domain.schoolSubjects.Science;
import ac.za.repository.IRepository;

import java.util.Set;

public interface ScienceRepository extends IRepository<Science, String> {
    Set<Science> getAll();

}