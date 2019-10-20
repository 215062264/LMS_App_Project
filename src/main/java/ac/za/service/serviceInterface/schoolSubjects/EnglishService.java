package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.English;
import ac.za.service.IService;

import java.util.Set;

public interface EnglishService extends IService<English, String> {
    Set<English> getAllEng();
    Set<English> getAll();
}
