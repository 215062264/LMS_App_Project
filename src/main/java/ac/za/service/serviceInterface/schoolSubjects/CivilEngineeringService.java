package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.service.IService;

import java.util.Set;

public interface CivilEngineeringService extends IService<CivilEngineering, String> {

    Set<CivilEngineering> getAllCivil();
    Set<CivilEngineering> getAll();
}
