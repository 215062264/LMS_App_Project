package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Geography;
import ac.za.service.IService;

import java.util.Set;


public interface GeographyService extends IService<Geography, String> {
    Set<Geography> getAllGeo();
    Set<Geography> getAll();
}
