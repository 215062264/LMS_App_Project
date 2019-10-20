package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.repository.IRepository;

import java.util.Set;

public interface CivilEngineeringRepository extends IRepository<CivilEngineering, String> {
    Set<CivilEngineering> getAll();

}