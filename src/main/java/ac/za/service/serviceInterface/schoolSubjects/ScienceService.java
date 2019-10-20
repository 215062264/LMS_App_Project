package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Science;
import ac.za.service.IService;

import java.util.Set;

public interface ScienceService extends IService<Science, String> {

    Set<Science> getAllP();
    Set<Science> getAll();
}
