package ac.za.repository.repoInterface.schoolSubjects;


import ac.za.domain.schoolSubjects.TechnicalDrawings;
import ac.za.repository.IRepository;

import java.util.Set;


public interface TechnicalDrawingsRepository extends IRepository<TechnicalDrawings, String> {
    Set<TechnicalDrawings> getAll();

}