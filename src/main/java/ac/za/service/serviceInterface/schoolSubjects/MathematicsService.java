package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Mathematics;
import ac.za.service.IService;

import java.util.Set;

public interface MathematicsService extends IService<Mathematics,String> {
    Set<Mathematics> getAllMath();
    Set<Mathematics> getAll();
}
