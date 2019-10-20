package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.LifeOrientation;
import ac.za.service.IService;

import java.util.Set;

public interface LifeOrientationService extends IService<LifeOrientation, String> {
    Set<LifeOrientation> getAllLO();
    Set<LifeOrientation> getAll();
}
