package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Mathematics;
import ac.za.repository.IRepository;

import java.util.Set;

public interface MathsRepository extends IRepository<Mathematics, String> {
    Set<Mathematics> getAll();

}
