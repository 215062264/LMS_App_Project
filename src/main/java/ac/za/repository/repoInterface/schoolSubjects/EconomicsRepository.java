package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Economics;
import ac.za.repository.IRepository;

import java.util.Set;

public interface EconomicsRepository extends IRepository<Economics, String> {
    Set<Economics> getAll();

}