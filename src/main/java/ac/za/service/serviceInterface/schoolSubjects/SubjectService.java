package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.service.IService;

import java.util.Set;

public interface SubjectService extends IService<Subject, String> {
    Set<Subject> getAllP();
    Set<Subject> getAll();
}
