package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Economics;
import ac.za.service.IService;

import java.util.Set;

public interface EconomicsService extends IService<Economics, String> {
    Set<Economics> getAllCivil();
    Set<Economics> getAll();
}
