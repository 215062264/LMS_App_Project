package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Physics;
import ac.za.repository.IRepository;

import java.util.Set;

public interface PhysicsRepository extends IRepository<Physics, String> {
    Set<Physics> getAll();

}