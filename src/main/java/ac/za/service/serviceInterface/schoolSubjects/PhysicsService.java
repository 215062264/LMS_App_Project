package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Physics;
import ac.za.service.IService;

import java.util.Set;

public interface PhysicsService extends IService<Physics, String> {
    Set<Physics> getAllP();
    Set<Physics> getAll();
}
