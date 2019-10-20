package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.InformationTech;
import ac.za.repository.IRepository;

import java.util.Set;

public interface InformationTechRepository extends IRepository<InformationTech, String> {
    Set<InformationTech> getAll();

}
