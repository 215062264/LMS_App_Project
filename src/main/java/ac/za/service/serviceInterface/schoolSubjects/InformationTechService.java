package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.InformationTech;
import ac.za.service.IService;

import java.util.Set;

public interface InformationTechService extends IService<InformationTech, String> {
    Set<InformationTech> getAllIt();
    Set<InformationTech> getAll();
}
