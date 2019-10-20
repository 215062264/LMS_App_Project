package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.repository.IRepository;

import java.util.Set;

public interface SubjectRepository extends IRepository<Subject, String> {
    Set<Subject> getAll();

}
