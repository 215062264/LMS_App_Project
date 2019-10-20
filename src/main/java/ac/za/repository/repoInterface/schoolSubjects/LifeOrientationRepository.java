package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.LifeOrientation;
import ac.za.repository.IRepository;

import java.util.Set;

public interface LifeOrientationRepository extends IRepository<LifeOrientation, String> {
    Set<LifeOrientation> getAll();

}