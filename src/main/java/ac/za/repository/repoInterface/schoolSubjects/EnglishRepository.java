package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.English;
import ac.za.repository.IRepository;

import java.util.Set;

public interface EnglishRepository extends IRepository<English, String> {
    Set<English> getAll();

}